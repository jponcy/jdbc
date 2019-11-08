package com.tactfactory.dbexample.fixtures.services.fixtures;

import javax.transaction.Transactional;

public interface Fixture {
    @Transactional
    void load();
}
