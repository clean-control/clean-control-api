package com.example.cleancontrol.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.Services;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer>{

}
