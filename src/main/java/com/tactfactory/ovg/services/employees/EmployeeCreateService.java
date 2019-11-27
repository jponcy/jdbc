package com.tactfactory.ovg.services.employees;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.repositories.EmployeeRepository;

@Component
@Transactional
public class EmployeeCreateService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeCreateService.class);

    @Autowired
    private EmployeeRepository repository;

    public Employee create(final Employee employee) {
        log.debug("Create employee");
        // Upload avatar.
        // Create avatar entry.
        return this.repository.save(employee);
    }
}
