package com.ticket.inventory_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.entity.SeatStatus;
import com.ticket.inventory_service.event.SeatEvent;
import com.ticket.inventory_service.kafka.SeatEventProducer;
import com.ticket.inventory_service.repository.SeatRepository;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final SeatEventProducer seatEventProducer;

    public SeatService(SeatRepository seatRepository, SeatEventProducer seatEventProducer) {
        this.seatRepository = seatRepository;
        this.seatEventProducer = seatEventProducer;
    }

    // Get available seats for an event
    public List<Seat> getAvailableSeats(String eventId) {
        return seatRepository.findByEventIdAndStatus(eventId, SeatStatus.AVAILABLE);
    }

    // Reserve a seat
    public Seat reserveSeat(String seatId) {

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (seat.getStatus() != SeatStatus.AVAILABLE) {
            throw new RuntimeException("Seat already reserved");
        }

        seat.setStatus(SeatStatus.RESERVED);
        seat.setExpiryTime(LocalDateTime.now().plusMinutes(1));

        Seat savedSeat = seatRepository.save(seat);

        // Send Kafka event
        SeatEvent event = new SeatEvent(savedSeat.getId(), savedSeat.getEventId(), "RESERVED");
        seatEventProducer.sendSeatEvent(event);

        return savedSeat;
    }

    // Automatically release expired seats
    @Scheduled(fixedRate = 30000)
    public void releaseExpiredSeats() {

        List<Seat> seats = seatRepository.findAll();

        for (Seat seat : seats) {

            if (seat.getStatus() == SeatStatus.RESERVED &&
                seat.getExpiryTime() != null &&
                seat.getExpiryTime().isBefore(LocalDateTime.now())) {

                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setExpiryTime(null);

                Seat savedSeat = seatRepository.save(seat);

                // Send Kafka event
                SeatEvent event = new SeatEvent(savedSeat.getId(), savedSeat.getEventId(), "RELEASED");
                seatEventProducer.sendSeatEvent(event);
            }
        }
    }
}