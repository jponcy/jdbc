package com.tactfactory.ovg.services;

import java.util.List;

import com.tactfactory.ovg.entities.PokemonSpecies;
import com.tactfactory.ovg.repositories.PokemonSpeciesRepository;

public class CrudPokemonSpeciesService extends CrudService<PokemonSpecies, PokemonSpeciesRepository> {

    @Override
    public List<PokemonSpecies> findAll() {
        return super.findAll();
    }
}
