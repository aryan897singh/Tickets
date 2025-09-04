package com.dauntlesstechnologies.springboot.tickets.registration;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;



public interface RegistrationRepository extends MongoRepository<Registration, String> {

    public Optional<Registration> findByTicketCode(String ticketCode);

    public void deleteByTicketCode(String ticketCode);
}





