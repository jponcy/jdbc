package com.tactfactory.dbexample.jdbc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.dbexample.jdbc.entities.Event;
import com.tactfactory.dbexample.jdbc.repositories.EventRepository;

@RestController
@RequestMapping("event")
public class EventController extends CrudController<Event, EventRepository> {
}
