package com.gtecnologia.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtecnologia.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
