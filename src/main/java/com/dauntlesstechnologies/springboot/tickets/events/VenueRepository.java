package com.dauntlesstechnologies.springboot.tickets.events;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final List<Venue> venues = List.of(
            new Venue(201, "Globomantics Main Office", "Test Street 325", "New York", "USA"),
            new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA")
    );

    //NOTE THE OPTIONAL<> CAN HOLD AT MOST ONE ITEM AND CAN BE NULL (TO AVOID NULL POINTER ERROR)
    public Optional<Venue> findById(int id){
        return venues.stream().filter(newVenue -> newVenue.id() == id ).findAny();

    }
}
