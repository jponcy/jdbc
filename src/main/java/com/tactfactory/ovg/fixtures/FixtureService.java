package com.tactfactory.ovg.fixtures;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class FixtureService implements Fixture {

    @Autowired
    private EmployeeFixtureService employeeFixtures;

    @Transactional(value = TxType.REQUIRES_NEW)
    @Override
    public void load() {
        this.employeeFixtures.load();
    }
}
