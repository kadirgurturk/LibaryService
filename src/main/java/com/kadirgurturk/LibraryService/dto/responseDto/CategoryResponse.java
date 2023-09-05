package com.kadirgurturk.LibraryService.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.LibraryService.data.entity.Book;
import com.kadirgurturk.LibraryService.data.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponse {

    @JsonProperty("categoryName")
    private String name;
    @JsonProperty("books")
    private List<String> booknames;

    public CategoryResponse categoryToResponseDto(Category entity){

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.name = entity.getName();

        for( var book : entity.getBooks()){
            categoryResponse.booknames.add(book.getName());
        }

        return categoryResponse;
    }

    public List<CategoryResponse> bookToResponseDto(List<Category> entities){
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (var entity : entities){
            categoryResponses.add(categoryToResponseDto(entity));
        }

        return categoryResponses;
    }
}
