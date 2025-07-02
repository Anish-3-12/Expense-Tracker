package com.anish.expense_tracker_app.service.impl;

import com.anish.expense_tracker_app.dto.CategoryDto;
import com.anish.expense_tracker_app.entity.Category;
import com.anish.expense_tracker_app.mapper.CategoryMapper;
import com.anish.expense_tracker_app.repository.CategoryRepository;
import com.anish.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        //convert CategoryDto to Category entity
        Category category= CategoryMapper.mapToCategory(categoryDto);

        // save category object to database table-categories
        Category savedCategory=categoryRepository.save(category);

        //convert savedCategory to CategoryDto
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID:"));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories=categoryRepository.findAll();
        return categories.stream()
                .map(category -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }
}
