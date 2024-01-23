package com.local.library.service;

import com.local.library.domain.AuthorRepository;
import com.local.library.domain.BookRepository;
import com.local.library.domain.GenreRepository;
import com.local.library.dto.BookDetail;
import com.local.library.model.Author;
import com.local.library.model.Book;
import com.local.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    public ResponseEntity<BookDetail> bookDetailData(Long id) {
        Book book = bookRepository.getReferenceById(id);
        Author author = authorRepository.getReferenceById(book.getAuthorid());
        Genre genre = genreRepository.getReferenceById(book.getGenreid());

        return ResponseEntity.ok(new BookDetail(book, author, genre));
    }
}
