package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Book;
import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    
}
