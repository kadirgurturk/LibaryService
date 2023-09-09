package com.kadirgurturk.LibraryService.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookRequest {

    @NotNull
    @Size(min = 3)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate publishDate;

    @NotNull
    @Min(25)
    private Integer pageCount;

    @NotNull
    @Size(min = 3)
    private String language;


    private List<Long> authorIds;

    @NotNull
    private Long categoryId;
}
