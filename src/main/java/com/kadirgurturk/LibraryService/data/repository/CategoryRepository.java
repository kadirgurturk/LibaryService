package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Author;
import com.kadirgurturk.LibraryService.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
