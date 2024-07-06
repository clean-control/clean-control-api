package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
