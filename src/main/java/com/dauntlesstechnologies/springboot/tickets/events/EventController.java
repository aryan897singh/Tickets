package com.dauntlesstechnologies.springboot.tickets.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository,
                           EventRepository eventRepository,
                           ProductRepository productRepository) {
            this.organizerRepository = organizerRepository;
            this.eventRepository = eventRepository;
            this.productRepository = productRepository;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/organizers") More specialized mapping below:
    @GetMapping(path = "/organizers")
    public List<Organizer> getOrganizers(){
        return organizerRepository.findAll();
    }

    @GetMapping(path = "/events")
    public List<Event> getEventsByOrganizer(@RequestParam("organizerId") int organizerId){
        return eventRepository.findByOrganizer(organizerId);

    }

    @GetMapping(path = "/events/{id}")
    public Event getEventById(@PathVariable("id") int eventID){
        return eventRepository.findById(eventID)
                .orElseThrow(() -> new NoSuchElementException("Event with id " + eventID + " not found"));
    }

    @GetMapping(path = "/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId){
        return productRepository.findByEventId(eventId);
    }

    @GetMapping(path = "/aroo")
    public String getAroo(){
        return "OHHHHHHHHHHHHHH MY GOD MY FIRST EVER PAGE\n ";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse notFound(NoSuchElementException ex){
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }




}
