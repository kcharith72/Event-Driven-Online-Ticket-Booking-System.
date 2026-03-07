package com.ticket.bookingservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.bookingservice.model.Event;
import com.ticket.bookingservice.model.Seat;
import com.ticket.bookingservice.service.EventService;
import com.ticket.bookingservice.service.InventoryServiceClient;

@RestController
public class EventController {

    private final EventService eventService;
    private final InventoryServiceClient inventoryServiceClient;

    public EventController(EventService eventService,
                           InventoryServiceClient inventoryServiceClient) {
        this.eventService = eventService;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/events/{eventId}/seats")
    public List<Seat> getSeats(@PathVariable String eventId) {
        return inventoryServiceClient.getSeats(eventId);
    }
}