package com.example.cleancontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cleancontrol.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer>{

}
