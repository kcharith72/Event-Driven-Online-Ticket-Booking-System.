package com.ticket.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.repository.SeatRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final SeatRepository seatRepository;

    public DataLoader(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public void run(String... args) {

        // Only insert if empty
        if (seatRepository.count() == 0) {

            seatRepository.save(new Seat("A1", "E1", "AVAILABLE"));
            seatRepository.save(new Seat("A2", "E1", "AVAILABLE"));
            seatRepository.save(new Seat("A3", "E1", "AVAILABLE"));

            System.out.println("Sample seats inserted.");
        }
    }
}