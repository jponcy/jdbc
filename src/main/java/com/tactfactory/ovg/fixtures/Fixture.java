package com.tactfactory.ovg.fixtures;

import javax.transaction.Transactional;

public interface Fixture {

    @Transactional
    void load();
}
