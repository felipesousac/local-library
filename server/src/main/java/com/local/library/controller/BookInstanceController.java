package com.local.library.controller;

import com.local.library.domain.BookInstanceRepository;
import com.local.library.model.BookInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/bookinstances")
public class BookInstanceController {

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @GetMapping
    private ResponseEntity<Iterable<BookInstance>> bookInstancesList() {
        return ResponseEntity.ok(bookInstanceRepository.findBookinstanceWithBookNames());
    }
}
