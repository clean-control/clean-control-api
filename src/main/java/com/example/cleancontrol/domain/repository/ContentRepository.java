package com.example.cleancontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>{

}
