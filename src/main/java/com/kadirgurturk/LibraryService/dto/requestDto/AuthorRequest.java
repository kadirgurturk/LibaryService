package com.kadirgurturk.LibraryService.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kadirgurturk.LibraryService.data.entity.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorRequest {

    @NotNull
    @Size(min = 3)
    private String name;
    @NotNull
    private Long zipcodeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @NotNull
    private boolean alive;

}
