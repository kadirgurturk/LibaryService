package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotNull
    @Size(min = 3)
    private String name;
}
