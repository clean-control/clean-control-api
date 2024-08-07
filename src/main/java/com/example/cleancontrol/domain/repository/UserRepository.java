package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
