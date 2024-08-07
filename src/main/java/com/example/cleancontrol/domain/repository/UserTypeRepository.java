package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

    UserType findByName(String name);

}
