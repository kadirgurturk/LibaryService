package com.kadirgurturk.LibraryService.data.repository;

import com.kadirgurturk.LibraryService.data.entity.Category;
import com.kadirgurturk.LibraryService.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    
}
