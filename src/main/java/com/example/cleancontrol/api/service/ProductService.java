package com.example.cleancontrol.api.service;

import com.example.cleancontrol.domain.model.Product;
import com.example.cleancontrol.domain.repository.ProductRepository;

import com.example.cleancontrol.api.dto.productDto.ProductRequest;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow();
        return product;
    }

    public Product save(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setActive(productRequest.active());
        product.setPrice(productRequest.price());
        product = productRepository.save(product);
        return product;
    }

    public Product update(Integer id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setActive(productRequest.active());
        product.setPrice(productRequest.price());
        product = productRepository.save(product);
        return product;
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}
