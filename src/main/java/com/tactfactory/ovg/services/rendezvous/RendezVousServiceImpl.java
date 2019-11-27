package com.tactfactory.ovg.services.rendezvous;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.ovg.entities.RendezVous;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.repositories.RendezVousRepository;
import com.tactfactory.ovg.services.RendezVousService;

@Transactional
@Service
public class RendezVousServiceImpl implements RendezVousService {

    @Autowired
    private RendezVousRepository repository;

    @Autowired
    private RendezVousDeleteService delete;

    public List<RendezVous> getAll() {
        return this.repository.findAll();
    }

    public void delete(final long id) throws NotFoundException {
        this.delete.delete(id);
    }

    public RendezVous create(final RendezVous entity) {
        return this.repository.save(entity);
    }
}
