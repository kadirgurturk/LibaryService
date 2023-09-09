package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ZipCodeRequest {
    @NotNull
    @Size(min = 3)
    private String name;
    @NotNull
    private Long cityId;
}
