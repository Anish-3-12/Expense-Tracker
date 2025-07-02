package com.anish.expense_tracker_app.mapper;

import com.anish.expense_tracker_app.dto.CategoryDto;
import com.anish.expense_tracker_app.dto.ExpenseDto;
import com.anish.expense_tracker_app.entity.Category;
import com.anish.expense_tracker_app.entity.Expense;

public class ExpenseMapper {

    //Map Expense Entity to ExpenseDto
    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    //Map expenseDto to expense entity
    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

         return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );

    }

}
