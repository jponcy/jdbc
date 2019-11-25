package com.tactfactory.ovg.services;

import java.util.List;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.exceptions.NotFoundException;

public interface EmployeeCrudService {

    List<Employee> getAll();

    Employee getOne(long id) throws NotFoundException;

    Employee create(Employee employee);
}
