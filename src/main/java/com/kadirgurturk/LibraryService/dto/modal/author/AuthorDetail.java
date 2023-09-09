package com.kadirgurturk.LibraryService.dto.modal.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetail {
    private String authorName;
    private String cityName;
    private LocalDate authorBirthDate;
    private List<BookDetail> books;
}
