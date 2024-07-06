package com.example.cleancontrol.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>{

}
