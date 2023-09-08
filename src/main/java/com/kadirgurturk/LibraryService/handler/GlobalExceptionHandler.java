package com.kadirgurturk.LibraryService.handler;

import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
import com.kadirgurturk.LibraryService.dto.responseDto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApıResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        ApıResponse<?> serviceResponse = new ApıResponse<>();
        List<ErrorResponse> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorResponse errorResponse = new ErrorResponse(error.getField(), error.getDefaultMessage());
                    errors.add(errorResponse);
                });

        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApıResponse<?> illeagalArgumentException(IllegalArgumentException exception) {
        ApıResponse<?> serviceResponse = new ApıResponse<>();
        List<ErrorResponse> errors = new ArrayList<>();

        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), exception.getMessage());
        errors.add(errorResponse);

        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    @ExceptionHandler(RuntimeException.class)
    public ApıResponse<?> runTimeException(RuntimeException exception) {
        ApıResponse<?> serviceResponse = new ApıResponse<>();
        List<ErrorResponse> errors = new ArrayList<>();

        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), exception.getMessage());
        errors.add(errorResponse);

        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }
}
