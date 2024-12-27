package com.nikhil.example.expense.service;

import com.nikhil.example.expense.dto.ExpenseDTO;
import com.nikhil.example.expense.entity.Category;
import com.nikhil.example.expense.entity.Expense;
import com.nikhil.example.expense.mapper.ExpenseMapper;
import com.nikhil.example.expense.repository.CategoryRepository;
import com.nikhil.example.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    ExpenseRepository expenseRepository;
    CategoryRepository categoryRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDTO);
        return ExpenseMapper.mapToExpenseDto(expenseRepository.save(expense));
    }

    @Override
    public ExpenseDTO getExpenseByID(Long id) {
        Expense expense = expenseRepository.getReferenceById(id);
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenseList = expenseRepository.findAll();
        return expenseList.stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.mapToExpense(getExpenseByID(id));
        expense.setAmount(expenseDTO.amount());
        expense.setExpenseDate(expenseDTO.expenseDate());
        if (expenseDTO.categoryDTO() != null) {
            Category category = categoryRepository.getReferenceById(expenseDTO.categoryDTO().id());
            expense.setCategory(category);
        }
        expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(expense);

    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.getReferenceById(id);
        expenseRepository.delete(expense);
    }
}
