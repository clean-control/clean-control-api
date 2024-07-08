package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.File;

public interface FileRepository extends JpaRepository<File, Integer>{

}
