package com.ticket.inventory_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.service.SeatService;

@RestController
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats/{eventId}")
    public List<Seat> getAvailableSeats(@PathVariable String eventId) {
        return seatService.getAvailableSeats(eventId);
    }

    @GetMapping("/reserve/{seatId}")
public String reserveSeat(@PathVariable String seatId) {
    try {
        seatService.reserveSeat(seatId);
        return "Seat " + seatId + " reserved successfully";
    } catch (Exception e) {
        return e.getMessage();
    }
}
}