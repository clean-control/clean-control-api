package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.Transaction;

import com.example.cleancontrol.api.dto.transactionDto.TransactionResponse;
@Component
public class TransactionMapper {

    public TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .total(transaction.getTotal())
                .paymentMethod(transaction.getPaymentMethod())
                .transactionType(transaction.getTransactionType())
                .status(transaction.getStatus())
                .enterprise(transaction.getEnterprise())
                .client(transaction.getClient())
                .createDate(transaction.getCreateDate())
                .updateDate(transaction.getUpdateDate())
                .build();
    }

    public Transaction toEntity(TransactionResponse transactionResponse) {
        return Transaction.builder()
                .id(transactionResponse.id())
                .total(transactionResponse.total())
                .paymentMethod(transactionResponse.paymentMethod())
                .transactionType(transactionResponse.transactionType())
                .status(transactionResponse.status())
                .enterprise(transactionResponse.enterprise())
                .client(transactionResponse.client())
                .createDate(transactionResponse.createDate())
                .updateDate(transactionResponse.updateDate())
                .build();
    }

    public List<TransactionResponse> toResponse(List<Transaction> transactions) {
        return transactions.stream().map(this::toResponse).toList();
    }

}