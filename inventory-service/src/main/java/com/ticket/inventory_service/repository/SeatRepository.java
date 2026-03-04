package com.ticket.inventory_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.inventory_service.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

    List<Seat> findByEventIdAndStatus(String eventId, String status);
}
