package com.kadirgurturk.LibraryService.dto.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class BookForAuthor {

    @JsonProperty("bookName")
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private Integer pageCount;
    private String language;
    private String categoryName;

}
