package com.gtecnologia.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtecnologia.store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
