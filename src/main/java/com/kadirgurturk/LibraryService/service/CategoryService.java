package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.Category;
import com.kadirgurturk.LibraryService.data.repository.CategoryRepository;
import com.kadirgurturk.LibraryService.dto.requestDto.CategoryRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.CategoryResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category getCategory(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(() ->
                new IllegalArgumentException("could not find category with id: " +  categoryId));
    }

    public CategoryResponse addCategroy(CategoryRequest categoryRequest){

        Category category = new Category();

        category.setName(categoryRequest.getName());
        categoryRepository.save(category);

        return CategoryResponse.categoryToResponseDto(category);

    }

    public CategoryResponse getCategoryById(Long categoryId) {
        Category category = getCategory(categoryId);
        return CategoryResponse.categoryToResponseDto(category);
    }

    public List<CategoryResponse> getCategories(){
        List<Category> categories = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return CategoryResponse.bookToResponseDto(categories);
    }

    public CategoryResponse deleteCategory(Long categotyId){
        Category category = getCategory(categotyId);
        categoryRepository.delete(category);
        return CategoryResponse.categoryToResponseDto(category);
    }

    @Transactional
    public CategoryResponse editCategory(Long categoryId, CategoryRequest categoryRequestDto) {
        Category categoryToEdit = getCategory(categoryId);
        categoryToEdit.setName(categoryRequestDto.getName());

        return CategoryResponse.categoryToResponseDto(categoryToEdit);
    }

}
