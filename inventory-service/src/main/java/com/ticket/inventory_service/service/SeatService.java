package com.ticket.inventory_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.repository.SeatRepository;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // Get available seats for event
    public List<Seat> getAvailableSeats(String eventId) {
        return seatRepository.findByEventIdAndStatus(eventId, "AVAILABLE");
    }

    // Reserve seat (prevents double booking)
    public Seat reserveSeat(String seatId) {

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (!seat.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Seat already reserved");
        }

        seat.setStatus("RESERVED");
        seat.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        return seatRepository.save(seat);
    }
}
