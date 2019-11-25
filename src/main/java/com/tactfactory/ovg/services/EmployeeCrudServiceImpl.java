package com.tactfactory.ovg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.repositories.EmployeeRepository;

@Service
public class EmployeeCrudServiceImpl implements EmployeeCrudService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeCreateService createService;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public Employee create(final Employee employee) {
        return this.createService.create(employee);
    }
}
