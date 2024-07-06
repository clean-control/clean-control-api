package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.EmployeeType;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer>{

}
