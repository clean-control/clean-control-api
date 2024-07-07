package com.example.cleancontrol.dto.transactionDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.Enterprise;
import com.example.cleancontrol.model.TransactionType;

import lombok.Builder;

@Builder
public record TransactionResponse(Integer id, Double total, String paymentMethod, TransactionType transactionType, String status, Enterprise enterprise, LocalDateTime createDate, LocalDateTime updateDate) {

}
