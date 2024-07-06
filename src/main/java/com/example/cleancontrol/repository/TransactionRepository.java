package com.example.cleancontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cleancontrol.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
