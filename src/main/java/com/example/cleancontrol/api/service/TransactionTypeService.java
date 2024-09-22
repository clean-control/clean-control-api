package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.domain.model.TransactionType;
import com.example.cleancontrol.domain.repository.TransactionTypeRepository;

import com.example.cleancontrol.api.dto.transactionTypeDto.TransactionTypeRequest;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionType save(TransactionTypeRequest transactionTypeRequest) {
        TransactionType transactionType = new TransactionType();

        transactionType.setName(transactionTypeRequest.name());
        transactionType.setDescription(transactionTypeRequest.description());
        transactionType.setActive(transactionTypeRequest.active());

        TransactionType savedTransactionType = transactionTypeRepository.save(transactionType);

        return savedTransactionType;

    }

    public List<TransactionType> findAll() {
        List<TransactionType> transactionTypes = transactionTypeRepository.findAll();
        return transactionTypes;
    }

    public TransactionType findById(Integer id) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));
        return transactionType;
    }

    public TransactionType update(Integer id, TransactionTypeRequest transactionTypeRequest) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));

        transactionType.setName(transactionTypeRequest.name());
        transactionType.setDescription(transactionTypeRequest.description());
        transactionType.setActive(transactionTypeRequest.active());

        TransactionType updatedTransactionType = transactionTypeRepository.save(transactionType);

        return updatedTransactionType;
    }

    public void delete(Integer id) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));

        transactionTypeRepository.delete(transactionType);
    }
}