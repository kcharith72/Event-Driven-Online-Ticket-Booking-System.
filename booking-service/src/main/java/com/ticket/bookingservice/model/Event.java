package com.ticket.bookingservice.model;

public class Event {

    private String eventId;
    private String name;
    private String showtime;

    public Event(String eventId, String name, String showtime) {
        this.eventId = eventId;
        this.name = name;
        this.showtime = showtime;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getShowtime() {
        return showtime;
    }
}
