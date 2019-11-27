package com.tactfactory.ovg.services.fixtures;

import javax.transaction.Transactional;

public interface Fixture {

    @Transactional
    void load();
}
