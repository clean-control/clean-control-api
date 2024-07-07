package com.example.cleancontrol.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.cleancontrol.domain.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
