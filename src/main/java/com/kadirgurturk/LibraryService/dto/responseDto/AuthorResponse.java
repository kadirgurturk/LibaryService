package com.kadirgurturk.LibraryService.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.data.entity.Book;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorResponse {

    @JsonProperty("authorName")
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private boolean alive;
    @JsonProperty("books")
    private List<String> books;
    private String zipcode;

    public static AuthorResponse authorToAuthorResponse(Author entity){

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.name = entity.getName();
        authorResponse.alive = entity.getAlive();
        authorResponse.birthDate = entity.getBirthDate();
        authorResponse.zipcode = entity.getZipcode().getName();

        for(var book : entity.getBooks()){
            authorResponse.books.add(book.getName());
        }

        return authorResponse;

    }
    public static List<AuthorResponse> authorResponses(List<Author> entities){
        List<AuthorResponse> authorResponses = new ArrayList<>();

        for (var entity : entities){
            authorResponses.add(authorToAuthorResponse(entity));
        }

        return authorResponses;
    }


}
