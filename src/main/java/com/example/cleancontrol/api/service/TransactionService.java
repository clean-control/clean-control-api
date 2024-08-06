package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.domain.model.Transaction;
import com.example.cleancontrol.api.mapper.TransactionMapper;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.TransactionType;
import com.example.cleancontrol.domain.repository.TransactionRepository;
import com.example.cleancontrol.domain.repository.TransactionTypeRepository;
import com.example.cleancontrol.domain.repository.EnterpriseRepository;
import com.example.cleancontrol.domain.repository.ClientRepository;
import com.example.cleancontrol.api.dto.transactionDto.TransactionRequest;
import com.example.cleancontrol.api.dto.transactionDto.TransactionResponse;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final ClientRepository clientRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionResponse save(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();

        Enterprise enterprise = enterpriseRepository.findById(transactionRequest.enterpriseId())
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        Client client = clientRepository.findById(transactionRequest.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        TransactionType transactionType = transactionTypeRepository.findById(transactionRequest.transactionTypeId())
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));

        transaction.setTotal(transactionRequest.total());
        transaction.setPaymentMethod(transactionRequest.paymentMethod());
        transaction.setTransactionType(transactionType);
        transaction.setStatus(transactionRequest.status());
        transaction.setEnterprise(enterprise);
        transaction.setClient(client);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return transactionMapper.toResponse(savedTransaction);

    }

    public List<TransactionResponse> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionMapper.toResponse(transactions);
    }

    public TransactionResponse findById(Integer id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return transactionMapper.toResponse(transaction);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }

    public TransactionResponse update(Integer id, TransactionRequest transactionRequest) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Enterprise enterprise = enterpriseRepository.findById(transactionRequest.enterpriseId())
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        Client client = clientRepository.findById(transactionRequest.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        TransactionType transactionType = transactionTypeRepository.findById(transactionRequest.transactionTypeId())
                .orElseThrow(() -> new RuntimeException("TransactionType not found"));

        transaction.setTotal(transactionRequest.total());
        transaction.setPaymentMethod(transactionRequest.paymentMethod());
        transaction.setTransactionType(transactionType);
        transaction.setStatus(transactionRequest.status());
        transaction.setEnterprise(enterprise);
        transaction.setClient(client);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return transactionMapper.toResponse(savedTransaction);

    }

}
