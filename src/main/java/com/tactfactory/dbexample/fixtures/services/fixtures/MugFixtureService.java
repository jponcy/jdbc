package com.tactfactory.dbexample.fixtures.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.tactfactory.dbexample.fixtures.entities.Mug;
import com.tactfactory.dbexample.fixtures.repositories.MugRepository;

@Component
@Profile("!prod")
public class MugFixtureService implements Fixture {

    @Autowired
    private MugRepository repository;

    @Override
    public void load() {
        Mug mug = new Mug();

        mug.setLabel("Meilleur maman du mmonde");
        mug.setPrice(13.99f);
        mug.setStock(23);

        this.repository.save(mug);
    }
}
