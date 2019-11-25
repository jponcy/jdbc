package com.tactfactory.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.ovg.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
