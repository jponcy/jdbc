package com.tactfactory.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Complete this one (example just started).
@RestController
@RequestMapping("rdv")
@Api(value = "Manage the Rendez-Vous", tags = "Rendez-Vous")
public class RendezVousController {

    @Autowired
    private RendezVousMapper mapper;

    @Autowired
    private RendezVousService service;

    @GetMapping
    @ApiOperation(value = "Retrieves all rendez-vous")
    public List<RendezVous> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    @ApiOperation(value = "Creates a new rendez-vous")
    public RendezVous create(@Valid @RequestBody final RendezVousFormDto dto) {
        final RendezVous entity = this.mapper.createFrom(dto);

        return this.service.create(entity);
    }
}
