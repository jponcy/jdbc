package com.tactfactory.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.ovg.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
