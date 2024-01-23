package com.local.library.controller;

import com.local.library.domain.BookRepository;
import com.local.library.dto.BookDetail;
import com.local.library.model.Book;
import com.local.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/{id}")
//    private ResponseEntity<Iterable<Book>> bookDetail(@PathVariable Long id) {
//        return ResponseEntity.ok(bookRepository.detailBookWithAuthorById(id));
//    }

    @GetMapping("/{id}")
    private ResponseEntity bookDetail(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.bookDetailData(id));
    }
}
