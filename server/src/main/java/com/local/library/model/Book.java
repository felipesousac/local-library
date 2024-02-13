package com.local.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "Book")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Long authorid;

    @NotBlank
    private String summary;

    @NotBlank
    private String isbn;

    @NotNull
    private Long genreid;

    public Book(Book book) {
        this.title = book.getTitle().trim();
        this.authorid = book.getAuthorid();
        this.summary = book.getSummary().trim();
        this.isbn = book.getIsbn();
        this.genreid = book.getGenreid();
    }
}
