package com.tactfactory.ovg.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.repositories.EmployeeRepository;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeCreateService createService;

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Employee getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Employee create(final Employee employee) {
        return this.createService.create(employee);
    }

    @Override
    public Employee update(final Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public void delete(long id) throws NotFoundException {
//        final Employee entity = this.getOne(id);
//        this.repository.delete(entity);

        this.repository.delete(this.getOne(id));
    }
}
