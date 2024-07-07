package com.example.cleancontrol.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.Scheduler;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer>{

}
