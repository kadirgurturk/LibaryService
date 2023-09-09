package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CityRequest {
    @NotNull
    @Size(min = 3)
    private String name;
}
