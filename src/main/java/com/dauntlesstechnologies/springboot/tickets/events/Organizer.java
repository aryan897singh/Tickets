package com.dauntlesstechnologies.springboot.tickets.events;

//this is a record, and it is an immutable java data carrier
public record Organizer(
        int id,
        String name,
        String description) {



}
