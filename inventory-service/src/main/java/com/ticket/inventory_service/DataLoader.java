package com.ticket.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.entity.SeatStatus;
import com.ticket.inventory_service.repository.SeatRepository;

@Configuration
public class DataLoader {

    @Bean
CommandLineRunner loadData(SeatRepository seatRepository) {
    return args -> {

        // Avengers seats
        seatRepository.save(new Seat("A1", "E1", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("A2", "E1", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("A3", "E1", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("A4", "E1", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("A5", "E1", SeatStatus.AVAILABLE));

        // Batman seats
        seatRepository.save(new Seat("B1", "E2", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("B2", "E2", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("B3", "E2", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("B4", "E2", SeatStatus.AVAILABLE));
        seatRepository.save(new Seat("B5", "E2", SeatStatus.AVAILABLE));

        System.out.println("Sample seats inserted.");
    };
}
}