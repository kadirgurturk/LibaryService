package com.kadirgurturk.LibraryService.dto.modal.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class AuthorDetail {
    private String authorName;
    private String cityName;
    private LocalDate authorBirthDate;
    private Set<BookDetail> books;

    public AuthorDetail(String authorName, String cityName, LocalDate authorBirthDate, Set<BookDetail> books) {
        this.authorName = authorName;
        this.cityName = cityName;
        this.authorBirthDate = authorBirthDate;
        this.books = books;
    }
}
