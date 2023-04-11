package edu.bru.eventmicroservice.repository;

import edu.bru.eventmicroservice.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName (String name);

}
