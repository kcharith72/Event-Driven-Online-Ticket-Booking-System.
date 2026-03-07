package com.ticket.inventory_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Seat {

    @Id
    private String id;

    private String eventId;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    private LocalDateTime expiryTime;

    public Seat() {
    }

    public Seat(String id, String eventId, SeatStatus status) {
        this.id = id;
        this.eventId = eventId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getEventId() {
        return eventId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}