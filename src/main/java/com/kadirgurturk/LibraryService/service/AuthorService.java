package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import com.kadirgurturk.LibraryService.data.repository.AuthorRepository;
import com.kadirgurturk.LibraryService.dto.requestDto.AuthorRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.AuthorResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ZipcodeService zipcodeService;

    @Transactional
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        if (authorRequest.getZipcodeId() == null) {
            throw new IllegalArgumentException("author need a zipcode");
        }
        Zipcode zipcode = zipcodeService.getZipcode(authorRequest.getZipcodeId());
        author.setZipcode(zipcode);
        authorRepository.save(author);
        return AuthorResponse.authorToAuthorResponse(author);
    }


    public List<AuthorResponse> getAuthors() {
        List<Author> authors = StreamSupport
                .stream(authorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return AuthorResponse.authorResponses(authors);
    }


    public AuthorResponse getAuthorById(Long authorId) {
        return AuthorResponse.authorToAuthorResponse(authorRepository.getReferenceById(authorId));
    }


    public Author getAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() ->
                new IllegalArgumentException(
                        "author with id: " + authorId + " could not be found"));
        return author;
    }


    public AuthorResponse deleteAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        authorRepository.delete(author);
        return AuthorResponse.authorToAuthorResponse(author);
    }

    @Transactional
    public AuthorResponse editAuthor(Long authorId, AuthorRequest authorRequestDto) {
        Author author = getAuthor(authorId);
        author.setName(authorRequestDto.getName());
        if (authorRequestDto.getZipcodeId() != null) {
            Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
            author.setZipcode(zipcode);
        }
        return AuthorResponse.authorToAuthorResponse(author);
    }

}
