package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

}
