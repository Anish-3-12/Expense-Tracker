package com.anish.expense_tracker_app.controller;


import com.anish.expense_tracker_app.dto.ExpenseDto;
import com.anish.expense_tracker_app.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for expense resource - "+
                "Create Expense, Update Expense, Get Expense and Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    //inject the ExpenseService using constructor based DI
    private ExpenseService expenseService;

    //Build Create expense REST API
    @Operation(
            summary = "Create Expense REST API",
            description = "Creating expense rest API to store in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense= expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    //Build GET expense REST API
    @Operation(
            summary = "Get Expense REST API",
            description = "To get expense rest API from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){

        ExpenseDto expense=expenseService.getExpenseById(expenseId);

        return ResponseEntity.ok(expense);

    }

    //Build get all expenses REST API
    @Operation(
            summary = "Get ALL Expense REST API",
            description = "To get all expenses rest API from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses=expenseService.getAllExpensees();

        return ResponseEntity.ok(expenses);
    }

    //Build update Expense REST API
    @Operation(
            summary = "Update Expense REST API",
            description = "To update expense rest API from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto updatedExpense=expenseService.updateExpense(expenseId,expenseDto);

        return ResponseEntity.ok(updatedExpense);
    }

    //Build delete expense REST API
    @Operation(
            summary = "Delete Expense REST API",
            description = "To delete expense rest API from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense Deleted Successfully");
    }

}
