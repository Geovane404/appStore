package com.gtecnologia.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtecnologia.store.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
