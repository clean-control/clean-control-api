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

import com.example.cleancontrol.api.dto.productTypeDto.ProductTypeRecord;
import com.example.cleancontrol.api.dto.productTypeDto.ProductTypeResponse;
import com.example.cleancontrol.api.mapper.ProductTypeMapper;
import com.example.cleancontrol.api.service.ProductTypeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/product-type")
@RequiredArgsConstructor
public class ProductTypeController {

    private final ProductTypeService productTypeService ;
    private final ProductTypeMapper productTypeMapper;

    @PostMapping
    public ResponseEntity<ProductTypeResponse> save(@RequestBody ProductTypeRecord productTypeRecord) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productTypeMapper.toResponse(productTypeService.save(productTypeRecord)));
    }

    @GetMapping
    public ResponseEntity<List<ProductTypeResponse>> findAll() {
        return ResponseEntity.ok(productTypeService.findAll().stream().map(productTypeMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productTypeMapper.toResponse(productTypeService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeResponse> update(@PathVariable Integer id, @RequestBody ProductTypeRecord productTypeRecord) {
        return ResponseEntity.ok(productTypeMapper.toResponse(productTypeService.update(id, productTypeRecord)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
