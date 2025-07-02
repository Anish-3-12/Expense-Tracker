package com.anish.expense_tracker_app.repository;

import com.anish.expense_tracker_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRespository extends JpaRepository<Expense, Long> {

    //Spring data jpa will provide implementation for this interface
    // Spring Data JPA provides transaction for all the CRUD methods



}
