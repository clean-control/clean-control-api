package com.example.cleancontrol.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.categoryDto.CategoryRequest;
import com.example.cleancontrol.api.mapper.CategoryMapper;
import com.example.cleancontrol.domain.model.Category;
import com.example.cleancontrol.domain.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper CategoryMapper;

    public List<Category> findAll() {

        try {
            List<Category> categories = categoryRepository.findAll();

            return categories;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar categorias");
        }
    }

    public Category findById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();
            return category;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar categorias");
        }
    }

    public Category save(CategoryRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

            Category category = CategoryMapper.toEntity(data);

            categoryRepository.save(category);

            return category;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar categoria");
        }
    }

    public Category update(Integer id, CategoryRequest data) {

        try {
            if (id == null || data == null) {
                throw new NullPointerException();
            }

            Category category = categoryRepository.findById(id).orElseThrow();

            category.setName(data.name() != null ? data.name() : category.getName());
            category.setDescription(data.description() != null ? data.description() : category.getDescription());
            category.setImgUrl(data.imgUrl() != null ? data.imgUrl() : category.getImgUrl());

            categoryRepository.save(category);

            return category;
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
