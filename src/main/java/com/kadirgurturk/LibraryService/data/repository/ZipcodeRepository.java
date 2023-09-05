package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Category;
import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends JpaRepository<Zipcode,Long> {
    
}
