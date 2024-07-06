package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
