package com.kadirgurturk.LibraryService.dto.responseDto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.LibraryService.data.entity.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookResponse {

    @JsonProperty("bookName")
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private Integer pageCount;
    private String language;
    @JsonProperty("authors")
    private List<String> authorName;
    private String categoryName;

    public static BookResponse bookToResponse(Book entity){

        BookResponse bookResponse = new BookResponse();

        bookResponse.name = entity.getName();
        bookResponse.pageCount = entity.getPageCount();
        bookResponse.pageCount = entity.getPageCount();
        bookResponse.language = entity.getLanguage();
        for( var author : entity.getAuthors()){
            bookResponse.authorName.add(author.getName());
        }

        bookResponse.categoryName = entity.getCategory().getName();

        return bookResponse;
    }

    public static List<BookResponse> bookToResponses(List<Book> entities){
       List<BookResponse> bookResponses = new ArrayList<>();

       for (var entity : entities){
           bookResponses.add(bookToResponse(entity));
       }

       return bookResponses;
    }



}
