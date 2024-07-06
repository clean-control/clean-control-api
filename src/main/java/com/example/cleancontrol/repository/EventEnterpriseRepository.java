package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.EventEnterprise;

@Repository
public interface EventEnterpriseRepository extends JpaRepository<EventEnterprise, Integer>{

}
