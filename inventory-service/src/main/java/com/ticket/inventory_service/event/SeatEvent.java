package com.ticket.inventory_service.event;

public class SeatEvent {

    private String seatId;
    private String eventId;
    private String status;

    public SeatEvent() {}

    public SeatEvent(String seatId, String eventId, String status) {
        this.seatId = seatId;
        this.eventId = eventId;
        this.status = status;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getStatus() {
        return status;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "SeatEvent{" +
                "seatId='" + seatId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}