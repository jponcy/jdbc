package com.tactfactory.ovg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.repositories.RendezVousRepository;

@Component
public class RendezVousDeleteService {

    @Autowired
    private RendezVousRepository repository;

    public void delete(final long id) throws NotFoundException {
        this.repository.delete(
                this.repository
                    .findById(id)
                    .orElseThrow(() -> new NotFoundException()));
    }
}
