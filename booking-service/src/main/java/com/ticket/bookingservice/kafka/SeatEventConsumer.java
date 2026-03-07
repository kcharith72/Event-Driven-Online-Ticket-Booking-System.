package com.ticket.bookingservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ticket.bookingservice.event.SeatEvent;

@Service
public class SeatEventConsumer {

    @KafkaListener(topics = "seat-events", groupId = "booking-service-group")
    public void consumeSeatEvent(SeatEvent event) {

        System.out.println("Booking Service received event: "
                + event.getSeatId() + " - " + event.getStatus());

    }
}