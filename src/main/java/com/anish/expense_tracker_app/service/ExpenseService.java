package com.anish.expense_tracker_app.service;

import com.anish.expense_tracker_app.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long expenseId);

    List<ExpenseDto> getAllExpensees();

    ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);

    void deleteExpense(Long expenseId);
}
