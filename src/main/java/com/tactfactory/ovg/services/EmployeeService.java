package com.tactfactory.ovg.services;

import java.util.List;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.exceptions.NotFoundException;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getOne(long id) throws NotFoundException;

    Employee create(Employee employee);

    Employee update(Employee employee);

    void delete(long id) throws NotFoundException;
}
