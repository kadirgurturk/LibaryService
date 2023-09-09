package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.dto.modal.author.AuthorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("SELECT NEW com.kadirgurturk.LibraryService.dto.modal.author.AuthorDetail" +
            "(a.name, z.city.name, a.birthDate, " +
            "  NEW com.kadirgurturk.LibraryService.dto.modal.author.BookDetail(b.name, b.publishDate, b.pageCount, b.language)) " +
            "FROM Author a " +
            "JOIN a.books b " +
            "JOIN a.zipcode z " +
            "WHERE a.id IN :authorId")
    Optional<AuthorDetail> findAuthorDetailsWithBooksByAuthorId(@Param("authorId") Long authorId);
}
