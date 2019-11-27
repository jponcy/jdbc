package com.tactfactory.ovg.services;

import java.util.List;

import com.tactfactory.ovg.entities.RendezVous;
import com.tactfactory.ovg.exceptions.NotFoundException;

public interface RendezVousService {

    /**
     * Returns all {@link RendezVous rendez-vous}.
     *
     * @return
     */
    List<RendezVous> getAll();

    /**
     * Deletes the {@link RendezVous rendez-vous} for given {@link RendezVous#id
     * id}.
     *
     * @param id The id of the {@link RendezVous rendez-vous} to delete.
     * @throws NotFoundException Throws if no {@link RendezVous rendez-vous} entity
     *                           exists for given {@code id}.
     */
    void delete(final long id) throws NotFoundException;

    /**
     * Saves in database the given {@link RendezVous rendez-vous}.
     *
     * @param entity The built entity.
     * @return The entity after hydratation.
     */
    RendezVous create(final RendezVous entity);
}
