package com.example.cleancontrol.api.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.service.CategoryService;
import com.example.cleancontrol.api.dto.categoryDto.*;
import com.example.cleancontrol.api.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategory(){

          try {
            List<CategoryResponse> category = categoryService.findAll().stream().map(categoryMapper::toResponse).collect(Collectors.toList());
            return ResponseEntity.ok(category);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Integer id){
        try {
            CategoryResponse category = categoryMapper.toResponse(categoryService.findById(id));
            return ResponseEntity.ok(category);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/active/{id}")
    public ResponseEntity<CategoryResponse> activeCategory(@PathVariable Integer id){
        try {
             categoryService.activeCategory(id);
             return ResponseEntity.noContent().build();
            
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest data){
        try {
            CategoryResponse category = categoryMapper.toResponse(categoryService.save(data));
            return ResponseEntity.status(201).body(category);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Integer id, @RequestBody CategoryRequest data){
        try {
            CategoryResponse category = categoryMapper.toResponse(categoryService.update(id, data));

            return ResponseEntity.ok(category);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        try {
             categoryService.delete(id);
             return ResponseEntity.noContent().build();
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }
}
