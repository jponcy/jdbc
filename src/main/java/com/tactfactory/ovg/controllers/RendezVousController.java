package com.tactfactory.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.ovg.dtos.RendezVousFormDto;
import com.tactfactory.ovg.entities.RendezVous;
import com.tactfactory.ovg.mappers.RendezVousMapper;
import com.tactfactory.ovg.services.RendezVousService;

@RestController
@RequestMapping("rdv")
public class RendezVousController {

    @Autowired
    private RendezVousMapper mapper;

    @Autowired
    private RendezVousService service;

    @GetMapping
    public List<RendezVous> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    public RendezVous create(@Valid @RequestBody final RendezVousFormDto dto) {
        final RendezVous entity = this.mapper.createFrom(dto);

        return this.service.create(entity);
    }
}
