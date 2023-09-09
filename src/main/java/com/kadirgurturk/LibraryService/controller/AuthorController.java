package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.dto.requestDto.AuthorRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
import com.kadirgurturk.LibraryService.dto.responseDto.AuthorResponse;
import com.kadirgurturk.LibraryService.dto.responseDto.CategoryResponse;
import com.kadirgurturk.LibraryService.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping()
    public ResponseEntity<?> addAuthor(@RequestBody @Valid final AuthorRequest authorRequest)
    {
        AuthorResponse authorResponse= authorService.addAuthor(authorRequest);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable final Long id) {
        AuthorResponse authorResponse = authorService.getAuthorById(id);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AuthorResponse>> getAuthors() {

        List<AuthorResponse> authorResponse = authorService.getAuthors();
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable final Long id) {
        AuthorResponse authorResponse = authorService.deleteAuthor(id);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    private ResponseEntity<?> editAuthor(@PathVariable final Long id,
                                                         @RequestBody @Valid final AuthorRequest authorRequest) {
        AuthorResponse authorResponse = authorService.editAuthor(id, authorRequest);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<?> addZipcode(@RequestParam("zipcode") final Long zipcodeId,
                                         @RequestParam("author") final Long authorId) {
        AuthorResponse authorResponse = authorService.addZipcodeToAuthor(authorId, zipcodeId);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/remove")
    private ResponseEntity<?> removeZipcode(@RequestParam("zipcode") final Long id) {
        AuthorResponse authorResponse = authorService.deleteZipcodeFromAuthor(id);
        ApıResponse<AuthorResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(authorResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

}
