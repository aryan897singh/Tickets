package com.dauntlesstechnologies.springboot.tickets.events;

import java.time.LocalDate;

public record Event(
        int id,
        String name,
        Organizer organizer,
        Venue venue,
        LocalDate localDate,
        LocalDate endDate) {
}
