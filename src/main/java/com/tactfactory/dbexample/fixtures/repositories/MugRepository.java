package com.tactfactory.dbexample.fixtures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.dbexample.fixtures.entities.Mug;

public interface MugRepository extends JpaRepository<Mug, Long> {
}
