package com.ticket.inventory_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ticket.inventory_service.event.SeatEvent;

@Service
public class SeatEventProducer {

    private final KafkaTemplate<String, SeatEvent> kafkaTemplate;

    public SeatEventProducer(KafkaTemplate<String, SeatEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSeatEvent(SeatEvent event) {
        kafkaTemplate.send("seat-events", event);
        System.out.println("Kafka Event Sent: " + event);
    }
}