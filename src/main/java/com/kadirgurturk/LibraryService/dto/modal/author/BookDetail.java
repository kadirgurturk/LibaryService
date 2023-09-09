package com.kadirgurturk.LibraryService.dto.modal.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetail {
    private String bookName;
    private LocalDate bookPublishDate;
    private Integer bookPageCount;
    private String bookLanguage;
}
