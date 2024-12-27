package com.nikhil.example.expense.service;

import com.nikhil.example.expense.dto.CategoryDTO;
import com.nikhil.example.expense.entity.Category;
import com.nikhil.example.expense.mapper.CategoryMapper;
import com.nikhil.example.expense.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.CategoryDTOtoEntity(categoryDTO);
        return CategoryMapper.CategorytoCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.getReferenceById(id);
        return CategoryMapper.CategorytoCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryMapper::CategorytoCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.getReferenceById(id);
        category.setName(categoryDTO.name());
        return CategoryMapper.CategorytoCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.delete(categoryRepository.getReferenceById(id));
        } else { // Handle the case where the category does not exist
            throw new EntityNotFoundException("Category with id " + id + " does not exist");
        }
    }
}
