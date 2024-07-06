package com.example.cleancontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cleancontrol.model.TransactionType;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer>{

}
