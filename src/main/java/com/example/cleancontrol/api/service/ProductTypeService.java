package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.cleancontrol.domain.repository.CategoryRepository;
import com.example.cleancontrol.domain.repository.ProductTypeRepository;

import com.example.cleancontrol.domain.model.ProductType;
import com.example.cleancontrol.api.mapper.ProductTypeMapper;
import com.example.cleancontrol.api.dto.productTypeDto.ProductTypeRecord;
import com.example.cleancontrol.api.dto.productTypeDto.ProductTypeResponse;


import java.util.List;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;

    private final CategoryRepository categoryRepository;

    public List<ProductTypeResponse> findAll() {
        List<ProductType> productTypes = productTypeRepository.findAll();
        return productTypes.stream().map(productTypeMapper::toResponse).collect(Collectors.toList());
    }

    public ProductTypeResponse findById(Integer id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow();
        return productTypeMapper.toResponse(productType);
    }


    public ProductTypeResponse save(ProductTypeRecord productTypeRecord) {
        ProductType productType = new ProductType();
        productType.setName(productTypeRecord.name());
        productType.setDescription(productTypeRecord.description());
        productType.setActive(productTypeRecord.active());
        productType.setCategory(categoryRepository.findById(productTypeRecord.categoryId()).orElse(null));
        productType = productTypeRepository.save(productType);
        return productTypeMapper.toResponse(productType);
    }


    public ProductTypeResponse update(Integer id, ProductTypeRecord productTypeRecord) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow();
        productType.setName(productTypeRecord.name());
        productType.setDescription(productTypeRecord.description());
        productType.setActive(productTypeRecord.active());
        productType.setCategory(categoryRepository.findById(productTypeRecord.categoryId()).orElse(null));
        productType = productTypeRepository.save(productType);
        return productTypeMapper.toResponse(productType);
    }

    public void delete(Integer id) {
        productTypeRepository.deleteById(id);
    }
    
}