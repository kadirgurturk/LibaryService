package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.dto.requestDto.BookRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
import com.kadirgurturk.LibraryService.dto.responseDto.AuthorResponse;
import com.kadirgurturk.LibraryService.dto.responseDto.BookResponse;
import com.kadirgurturk.LibraryService.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody @Valid final BookRequest bookRequestDto) {
        BookResponse bookResponse = bookService.addBook(bookRequestDto);

        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable final Long id) {
        BookResponse bookResponse = bookService.getBookById(id);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getBooks() {
        List<BookResponse> bookResponse = bookService.getBooks();

        ApıResponse<List<BookResponse>> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable final Long id) {
        BookResponse bookResponse = bookService.deleteBook(id);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editBook(@RequestBody @Valid final BookRequest bookRequest,
                                                    @PathVariable final Long id) {

        BookResponse bookResponse = bookService.editBook(id, bookRequest);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestParam("category") final Long categoryId,
                                         @RequestParam("book") final Long bookId) {
        BookResponse bookResponse = bookService.addCategoryToBook(bookId, categoryId);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> removeCategory(@RequestParam("category") final Long categoryId,
                                                          @RequestParam("book") final Long bookId) {
        BookResponse bookResponse = bookService.removeCategoryFromBook(bookId, categoryId);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addAuthor(@RequestParam("author") final Long authorId,
                                                  @RequestParam("book") final Long bookId) {
        BookResponse bookResponse = bookService.addAuthorToBook(bookId, authorId);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> removeAuthor(@RequestParam("author") final Long authorId,
                                                        @RequestParam("book") final Long bookId) {
        BookResponse bookResponse = bookService.removeAuthorFromBook(bookId, authorId);
        ApıResponse<BookResponse> apıResponse = new ApıResponse<>();

        apıResponse.setResults(bookResponse);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

}
