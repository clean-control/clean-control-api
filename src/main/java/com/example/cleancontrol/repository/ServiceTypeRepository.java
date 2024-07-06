package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer>{

}
