package edu.bru.eventmicroservice.service;


import edu.bru.eventmicroservice.model.Event;

import java.util.List;

public interface EventService {
    List<Event> get();
    Event getByName(String name);
}
