package com.tactfactory.dbexample.fixtures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.dbexample.fixtures.entities.Tasse;

public interface TasseRepository extends JpaRepository<Tasse, Long> {
}
