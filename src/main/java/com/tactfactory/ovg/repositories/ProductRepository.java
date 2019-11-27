package com.tactfactory.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.ovg.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
