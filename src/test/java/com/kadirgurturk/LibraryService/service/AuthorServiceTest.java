package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.data.repository.AuthorRepository;
import com.kadirgurturk.LibraryService.dto.responseDto.AuthorResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

 public class AuthorServiceTest {

    private AuthorService authorService;

    private  AuthorRepository authorRepository;
    private  ZipcodeService zipcodeService;


    @BeforeEach
    public void setup(){
      authorRepository = Mockito.mock(AuthorRepository.class);
      zipcodeService = Mockito.mock(ZipcodeService.class);

      authorService = new AuthorService(authorRepository,zipcodeService);

    }

    @Test
    public void addAuthorTest() {
    }

    @Test
    public void getAuthors() {
        var authorList = Arrays.asList(
                new Author(1L, "Author1", LocalDate.of(1990, 1, 1), true, null, null),
                new Author(2L, "Author2", LocalDate.of(1985, 5, 15), true, null, null),
                new Author(3L, "Author3", LocalDate.of(1978, 8, 20), false, null, null)
        );

        Mockito.when(authorRepository.findAll()).thenReturn(authorList);

       List<AuthorResponse> authorResponses = authorService.getAuthors();

       assertEquals(3, authorResponses.size());

    }

    @Test
    public void getAuthorById() {
    }

    @Test
    public void getAuthor() {
    }

    @Test
    public void deleteAuthor() {
    }

    @Test
    public void editAuthor() {
    }

    @Test
    public void addZipcodeToAuthor() {
    }

    @Test
    public void deleteZipcodeFromAuthor() {
    }

    @Test
    public void findAuthorDetail() {
    }
}