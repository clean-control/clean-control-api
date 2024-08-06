package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.TransactionType;

import com.example.cleancontrol.api.dto.transactionTypeDto.TransactionTypeResponse;

@Component
public class TransactionTypeMapper {

    public TransactionTypeResponse toResponse(TransactionType transactionType) {
        return TransactionTypeResponse.builder()
                .id(transactionType.getId())
                .name(transactionType.getName())
                .description(transactionType.getDescription())
                .active(transactionType.getActive())
                .createDate(transactionType.getCreateDate())
                .updateDate(transactionType.getUpdateDate())
                .build();
    }

    public TransactionType toEntity(TransactionTypeResponse transactionTypeResponse) {
        return TransactionType.builder()
                .id(transactionTypeResponse.id())
                .name(transactionTypeResponse.name())
                .description(transactionTypeResponse.description())
                .active(transactionTypeResponse.active())
                .createDate(transactionTypeResponse.createDate())
                .updateDate(transactionTypeResponse.updateDate())
                .build();
    }

    public List<TransactionTypeResponse> toResponse(List<TransactionType> transactionTypes) {
        return transactionTypes.stream().map(this::toResponse).toList();
    }
}
