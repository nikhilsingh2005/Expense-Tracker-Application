package com.nikhil.example.expense.service;

import com.nikhil.example.expense.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);
    ExpenseDTO getExpenseByID(Long id);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
}
