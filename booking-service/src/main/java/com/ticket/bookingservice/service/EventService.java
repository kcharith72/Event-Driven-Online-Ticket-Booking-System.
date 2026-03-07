package com.ticket.bookingservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ticket.bookingservice.model.Event;

@Service
public class EventService {

    public List<Event> getEvents() {

        return Arrays.asList(
                new Event("E1", "Avengers", "18:00"),
                new Event("E2", "Batman", "21:00")
        );

    }
}