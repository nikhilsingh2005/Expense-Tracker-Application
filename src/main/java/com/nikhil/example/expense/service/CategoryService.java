package com.nikhil.example.expense.service;

import com.nikhil.example.expense.dto.CategoryDTO;
import com.nikhil.example.expense.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategory();

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategoryById(Long id);


}
