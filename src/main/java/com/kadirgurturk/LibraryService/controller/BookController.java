package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;



}
