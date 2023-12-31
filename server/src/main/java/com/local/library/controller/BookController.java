package com.local.library.controller;

import com.local.library.domain.BookRepository;
import com.local.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    private Iterable<Book> bookList() {
        return bookRepository.findBookAndAuthorById();
    }
}
