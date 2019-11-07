package com.tactfactory.ovg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.ovg.entities.Event;
import com.tactfactory.ovg.repositories.EventRepository;

@RestController
@RequestMapping("event")
public class EventController extends CrudController<Event, EventRepository> {
}
