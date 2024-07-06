package com.example.cleancontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.model.Scheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer>{

}
