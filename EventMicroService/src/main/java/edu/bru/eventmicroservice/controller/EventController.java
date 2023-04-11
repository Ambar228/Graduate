package edu.bru.eventmicroservice.controller;

import edu.bru.eventmicroservice.model.Event;
import edu.bru.eventmicroservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/event")

public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> get() {
        return ResponseEntity.ok(eventService.get());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Event> getByName(@PathVariable String name) {
        return ResponseEntity.ok(eventService.getByName(name));
    }

}
