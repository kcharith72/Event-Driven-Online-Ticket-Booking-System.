package com.ticket.inventory_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seat {

    @Id
    private String id;

    private String eventId;

    private String status; // AVAILABLE or RESERVED

    private LocalDateTime expiryTime;

    public Seat() {}

    public Seat(String id, String eventId, String status) {
        this.id = id;
        this.eventId = eventId;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getExpiryTime() { return expiryTime; }
    public void setExpiryTime(LocalDateTime expiryTime) { this.expiryTime = expiryTime; }
}