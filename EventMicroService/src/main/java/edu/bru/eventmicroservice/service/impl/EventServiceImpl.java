package edu.bru.eventmicroservice.service.impl;

import edu.bru.eventmicroservice.model.Event;
import edu.bru.eventmicroservice.repository.EventRepository;
import edu.bru.eventmicroservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> get() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event getByName(String name) {
        return eventRepository.findByName(name);
    }
}
