package com.local.library.controller;

import com.local.library.domain.BookRepository;
import com.local.library.dto.BookDetail;
import com.local.library.model.Book;
import com.local.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("catalog/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping
    private ResponseEntity<Iterable<Book>> bookList() {
        return ResponseEntity.ok(bookRepository.findBookAndAuthorById());
    }

    @GetMapping("/{id}")
    private ResponseEntity bookDetail(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.bookDetailData(id));
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity bookName(@PathVariable Long id) {
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    @PostMapping
    private ResponseEntity createBook(@RequestBody @Valid Book book, UriComponentsBuilder uriBuilder) {
        return bookService.createBook(book, uriBuilder);
    }
}
