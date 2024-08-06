package com.example.cleancontrol.api.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.categoryDto.CategoryResponse;
import com.example.cleancontrol.api.mapper.CategoryMapper;
import com.example.cleancontrol.api.dto.categoryDto.CategoryRequest;
import com.example.cleancontrol.domain.model.Category;
import com.example.cleancontrol.domain.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper CategoryMapper;

    public List<CategoryResponse> findAll() {

        try {
            List<Category> categories = categoryRepository.findAll();

            return categories.stream().map(CategoryMapper::toResponse).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar categorias");
        }
    }

    public CategoryResponse findById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();
            return CategoryMapper.toResponse(category);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar categorias");
        }
    }

    public CategoryResponse save(CategoryRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

            Category category = CategoryMapper.toEntity(data);

            categoryRepository.save(category);

            return CategoryMapper.toResponse(category);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar categoria");
        }
    }

    public CategoryResponse update(Integer id, CategoryRequest data) {

        try {
            if (id == null || data == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();

            category.setName(data.name() != null ? data.name() : category.getName());
            category.setDescription(data.description() != null ? data.description() : category.getDescription());
            category.setImgUrl(data.imgUrl() != null ? data.imgUrl() : category.getImgUrl());

            categoryRepository.save(category);

            return CategoryMapper.toResponse(category);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar categoria");
        }
    }

    public void activeCategory(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();

            category.setActive(true);

            categoryRepository.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ativar categoria");
        }
    }

    public void delete(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();

            if (category.getActive()) {

                category.setActive(false);

                categoryRepository.save(category);
            }else{
                categoryRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar categoria");
        }
    }

}
