package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CityRequest {
    @NotNull
    @Min(3)
    private String name;
}
