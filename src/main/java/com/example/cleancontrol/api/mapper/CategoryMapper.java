package com.example.cleancontrol.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.categoryDto.CategoryRequest;
import com.example.cleancontrol.api.dto.categoryDto.CategoryResponse;
import com.example.cleancontrol.domain.model.Category;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName(), category.getDescription(), category.getImgUrl(), category.getActive(), category.getCreateDate(), category.getUpdateDate());
    }

    public List<CategoryResponse> toResponse(List<Category> category) {
        return category.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public Category toEntity(CategoryRequest categoryRequest) {
        return new Category(null, categoryRequest.name(), categoryRequest.description(), categoryRequest.imgUrl(), categoryRequest.active(), null, null);
    }


}
