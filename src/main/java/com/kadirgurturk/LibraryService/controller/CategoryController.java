package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.dto.requestDto.CategoryRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.CategoryResponse;
import com.kadirgurturk.LibraryService.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryResponse> addCategory(
            @RequestBody @Valid final CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.addCategroy(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<CategoryResponse> categoryResponse = categoryService.getCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.deleteCategory(id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> editCategory(
            @RequestBody @Valid final CategoryRequest categoryRequest,
            @PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.editCategory(id, categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }


}
