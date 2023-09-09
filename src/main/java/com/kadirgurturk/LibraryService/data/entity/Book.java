package com.kadirgurturk.LibraryService.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private LocalDate publishDate;

    private Integer pageCount;

    private String language;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Author> authors = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(String name, List<Author> authors, Category category) {
        this.name = name;
        this.authors = authors;
        this.category = category;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void deleteAuthor(Author author) {
        authors.remove(author);
    }
}
