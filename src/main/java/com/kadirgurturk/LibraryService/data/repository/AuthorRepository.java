package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
