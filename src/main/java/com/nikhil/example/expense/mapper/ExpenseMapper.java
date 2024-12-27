package com.nikhil.example.expense.mapper;

import com.nikhil.example.expense.dto.CategoryDTO;
import com.nikhil.example.expense.dto.ExpenseDTO;
import com.nikhil.example.expense.entity.Category;
import com.nikhil.example.expense.entity.Expense;

public class ExpenseMapper {

    // Map Expense entity to ExpenseDto
    public static ExpenseDTO mapToExpenseDto(Expense expense){
        return new ExpenseDTO(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDTO(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    // Map ExpenseDto to Expense entity
    public static Expense mapToExpense(ExpenseDTO expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDTO().id());
        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
