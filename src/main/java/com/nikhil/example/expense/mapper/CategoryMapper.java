package com.nikhil.example.expense.mapper;

import com.nikhil.example.expense.dto.CategoryDTO;
import com.nikhil.example.expense.entity.Category;

public class CategoryMapper {

    // map category dto to category entity
    public static Category CategoryDTOtoEntity(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()
        );
    }

    // map category class to category dto
    public static CategoryDTO CategorytoCategoryDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
}
