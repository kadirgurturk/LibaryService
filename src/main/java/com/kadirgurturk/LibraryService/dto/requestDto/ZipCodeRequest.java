package com.kadirgurturk.LibraryService.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ZipCodeRequest {
    @NotNull
    @Min(3)
    private String name;
    @NotNull
    private Long cityId;
}
