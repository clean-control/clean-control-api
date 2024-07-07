package com.example.cleancontrol.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
