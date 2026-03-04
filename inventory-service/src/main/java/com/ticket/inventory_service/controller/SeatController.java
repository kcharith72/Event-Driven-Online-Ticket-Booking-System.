package com.ticket.inventory_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.service.SeatService;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // View available seats for event
    @GetMapping("/{eventId}")
    public List<Seat> getAvailableSeats(@PathVariable String eventId) {
        return seatService.getAvailableSeats(eventId);
    }

    // Reserve a seat
    @GetMapping("/reserve/{seatId}")
    public Seat reserveSeat(@PathVariable String seatId) {
        return seatService.reserveSeat(seatId);
    }
}