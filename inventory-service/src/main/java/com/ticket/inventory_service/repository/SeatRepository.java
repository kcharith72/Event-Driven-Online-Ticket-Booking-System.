package com.ticket.inventory_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.inventory_service.entity.Seat;
import com.ticket.inventory_service.entity.SeatStatus;

public interface SeatRepository extends JpaRepository<Seat, String> {

    List<Seat> findByEventIdAndStatus(String eventId, SeatStatus status);

}