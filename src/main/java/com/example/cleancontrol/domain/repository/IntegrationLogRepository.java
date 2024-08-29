package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.IntegrationLog;
@Repository
public interface IntegrationLogRepository extends JpaRepository<IntegrationLog, Integer>{

}
