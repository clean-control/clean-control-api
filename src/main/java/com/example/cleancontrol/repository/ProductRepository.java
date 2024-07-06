package com.example.cleancontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
