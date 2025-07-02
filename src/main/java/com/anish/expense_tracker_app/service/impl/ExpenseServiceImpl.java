package com.anish.expense_tracker_app.service.impl;

import com.anish.expense_tracker_app.dto.ExpenseDto;
import com.anish.expense_tracker_app.entity.Category;
import com.anish.expense_tracker_app.entity.Expense;
import com.anish.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.anish.expense_tracker_app.mapper.ExpenseMapper;
import com.anish.expense_tracker_app.repository.CategoryRepository;
import com.anish.expense_tracker_app.repository.ExpenseRespository;
import com.anish.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    //inject ExpenseRepository\
    private ExpenseRespository expenseRespository;

    private CategoryRepository categoryRepository;


    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        //convert ExpenseDto to Expense Entity
        Expense expense= ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense=expenseRespository.save(expense);

        //Convert saved expense entity into expensDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {

        //Check if id exists
        Expense expense=expenseRespository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));

        //convert expense entity to expenseDto
        ExpenseDto expenseDto= ExpenseMapper.mapToExpenseDto(expense);
        return expenseDto;
    }

    @Override
    public List<ExpenseDto> getAllExpensees() {

        List<Expense> expenses=expenseRespository.findAll();
        return expenses.stream()
                .map(expense -> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {

        Expense expense= expenseRespository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));

        //update expenses
        expense.setAmount(expenseDto.amount());

        expense.setExpenseDate(expenseDto.expenseDate());

        //update Category
        if(expenseDto.categoryDto() != null){

            Category category=categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(()-> new ResourceNotFoundException("CAtegory not found with given Id"));

            expense.setCategory(category);
        }

        Expense updatedExpense= expenseRespository.save(expense);

        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRespository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));

        expenseRespository.delete(expense);
    }
}
