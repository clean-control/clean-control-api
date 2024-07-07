package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer>{

}
