package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.dto.requestDto.AuthorRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.AuthorResponse;
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
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable final Long id) {
        AuthorResponse authorResponse = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AuthorResponse>> getAuthors() {

        List<AuthorResponse> authorResponse = authorService.getAuthors();
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<AuthorResponse> deleteAuthor(@PathVariable final Long id) {
        AuthorResponse authorResponse = authorService.deleteAuthor(id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<AuthorResponse> editAuthor(@PathVariable final Long id,
                                                         @RequestBody @Valid final AuthorRequest authorRequest) {
        AuthorResponse authorResponse = authorService.editAuthor(id, authorRequest);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<AuthorResponse> addZipcode(@RequestParam("zipcode") final Long zipcodeId,
                                                      @RequestParam("author") final Long authorId) {
        AuthorResponse authorResponse = authorService.addZipcodeToAuthor(authorId, zipcodeId);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<AuthorResponse> removeZipcode(@RequestParam("zipcode") final Long id) {
        AuthorResponse authorResponseDto = authorService.deleteZipcodeFromAuthor(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

}
