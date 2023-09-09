package com.kadirgurturk.LibraryService.dto.modal.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class BookDetail {
    private String bookName;
    private LocalDate bookPublishDate;
    private Integer bookPageCount;
    private String bookLanguage;

    public BookDetail(String bookName, LocalDate bookPublishDate, Integer bookPageCount, String bookLanguage) {
        this.bookName = bookName;
        this.bookPublishDate = bookPublishDate;
        this.bookPageCount = bookPageCount;
        this.bookLanguage = bookLanguage;
    }
}
