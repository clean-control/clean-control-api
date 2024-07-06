package com.example.cleancontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cleancontrol.model.TransactionClient;

@Repository
public interface TransactionClientRepository extends JpaRepository<TransactionClient, Integer>{

}
