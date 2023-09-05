package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotNull
    private String name;
}
