package com.anish.expense_tracker_app.controller;

import com.anish.expense_tracker_app.dto.CategoryDto;
import com.anish.expense_tracker_app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource" +
                "Create Category, Update Category, Get Category, Delete Category"
)


@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    //Build createCategory REST API
    @Operation(
            summary = "Create Category REST API",
            description = "Creating Category to save in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "201 Created"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody CategoryDto categoryDto){

        CategoryDto category= categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //Build Get CategoryById REST API
    @Operation(
            summary = "GET Category REST API",
            description = "To get Category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDto category=categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    //Build Get All Category REST API
    @Operation(
            summary = "GET ALL Category REST API",
            description = "To get all Category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //Build update Category REST API
    @Operation(
            summary = "UPDATE Category REST API",
            description = "To update Category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory=categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    //Build delete Category REST API
    @Operation(
            summary = "DELETE Category REST API",
            description = "To delete Category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok("Category Deleted Successfully");
    }
}
