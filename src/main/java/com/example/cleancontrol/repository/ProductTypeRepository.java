package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cleancontrol.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

}

