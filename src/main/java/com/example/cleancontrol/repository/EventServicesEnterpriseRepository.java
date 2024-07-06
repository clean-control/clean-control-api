package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.EventServicesEnterprise;

@Repository
public interface EventServicesEnterpriseRepository extends JpaRepository<EventServicesEnterprise, Integer>{

}
