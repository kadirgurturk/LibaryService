package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.data.entity.City;
import com.kadirgurturk.LibraryService.dto.requestDto.CategoryRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
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
    public ResponseEntity<?> addCategory(
            @RequestBody @Valid final CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.addCategroy(categoryRequest);
        ApıResponse<CategoryResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(categoryResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(id);
        ApıResponse<CategoryResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(categoryResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getCategories() {
        List<CategoryResponse> categoryResponse = categoryService.getCategories();
        ApıResponse<List<CategoryResponse>> apıResponse = new ApıResponse<>();

        apıResponse.setResults(categoryResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.deleteCategory(id);
        ApıResponse<CategoryResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(categoryResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editCategory(
            @RequestBody @Valid final CategoryRequest categoryRequest,
            @PathVariable final Long id) {
        CategoryResponse categoryResponse = categoryService.editCategory(id, categoryRequest);
        ApıResponse<CategoryResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(categoryResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }


}
