package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.data.entity.Book;
import com.kadirgurturk.LibraryService.data.entity.Category;
import com.kadirgurturk.LibraryService.data.repository.BookRepository;
import com.kadirgurturk.LibraryService.dto.requestDto.BookRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.BookResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Transactional
    public BookResponse addBook(BookRequest bookRequest){
        var book = new Book();

        book.setName(bookRequest.getName());
        if(bookRequest.getAuthorIds().isEmpty()){
            throw new IllegalArgumentException("you need at least one author");
        } else{
            List<Author> authors = new ArrayList<>();

            for (Long authorId : bookRequest.getAuthorIds()) {
                var author = authorService.getAuthor(authorId);
                authors.add(author);
            }

            book.setAuthors(authors);
        }
        if(bookRequest.getCategoryId() != null){
            throw new IllegalArgumentException("book atleast on category");
        }

        Category category = categoryService.getCategory(bookRequest.getCategoryId());
        book.setCategory(category);

        bookRepository.save(book);

        return BookResponse.bookToResponse(book);
    }


    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + bookId));
        return book;
    }

    public BookResponse getBookById(Long bookId) {
        Book book = getBook(bookId);
        return BookResponse.bookToResponse(book);
    }


    public List<BookResponse> getBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return BookResponse.bookToResponses(books);
    }

    public BookResponse deleteBook(Long bookId){

        Book book = getBook(bookId);

        bookRepository.delete(book);

        return BookResponse.bookToResponse(book);
    }

    @Transactional
    public BookResponse editBook(Long bookId, BookRequest bookRequest){
        Book book = getBook(bookId);

        book.setName(bookRequest.getName());
        book.setLanguage(bookRequest.getLanguage());
        book.setPageCount(bookRequest.getPageCount());

        if(!bookRequest.getAuthorIds().isEmpty()){
            List<Author> authors = new ArrayList<>();
            for (Long authorId: bookRequest.getAuthorIds()) {
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }
        if (bookRequest.getCategoryId() != null) {
            Category category = categoryService.getCategory(bookRequest.getCategoryId());
            book.setCategory(category);
        }

        return BookResponse.bookToResponse(book);
    }

    @Transactional
    public BookResponse addAuthorToBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (author.getBooks().contains(author)) {
            throw new IllegalArgumentException("this author is already assigned to this book");
        }
        book.addAuthor(author);
        author.addBooks(book);
        return BookResponse.bookToResponse(book);
    }

    @Transactional
    public BookResponse removeAuthorFromBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (!(author.getBooks().contains(book))){
            throw new IllegalArgumentException("book does not have this author");
        }
        author.remove(book);
        book.deleteAuthor(author);
        return BookResponse.bookToResponse(book);
    }

    @Transactional
    public BookResponse addCategoryToBook(Long bookId, Long categoryId){
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if (Objects.nonNull(book.getCategory())){
            throw new IllegalArgumentException("book already has a catogory");
        }
        book.setCategory(category);
        category.addBook(book);

        return BookResponse.bookToResponse(book);
    }

    @Transactional
    public BookResponse removeCategoryFromBook(Long bookId, Long categoryId) {
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if (!(Objects.nonNull(book.getCategory()))){
            throw new IllegalArgumentException("book does not have a category to delete");
        }
        book.setCategory(null);
        category.removeBook(book);
        return BookResponse.bookToResponse(book);
    }


}
