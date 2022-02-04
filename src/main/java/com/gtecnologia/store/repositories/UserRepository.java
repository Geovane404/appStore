package com.gtecnologia.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtecnologia.store.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
