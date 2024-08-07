package com.example.cleancontrol.api.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.cleancontrol.api.dto.transactionTypeDto.TransactionTypeRequest;
import com.example.cleancontrol.api.dto.transactionTypeDto.TransactionTypeResponse;

import com.example.cleancontrol.api.service.TransactionTypeService;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/api/transactionType")
@RequiredArgsConstructor
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService ;

    @PostMapping
    public ResponseEntity<TransactionTypeResponse> save(@RequestBody TransactionTypeRequest transactionTypeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionTypeService.save(transactionTypeRequest));
    }

    @GetMapping
    public ResponseEntity<List<TransactionTypeResponse>> findAll() {
        return ResponseEntity.ok(transactionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTypeResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(transactionTypeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionTypeResponse> update(@PathVariable Integer id, @RequestBody TransactionTypeRequest transactionTypeRequest) {
        return ResponseEntity.ok(transactionTypeService.update(id, transactionTypeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        transactionTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
