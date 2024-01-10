package com.local.library.controller;

import com.local.library.domain.AuthorRepository;
import com.local.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Iterable<Author> authorList() {
        return authorRepository.findAllOrderByFamilyName();
    }

    @GetMapping("/{id}")
    public void authorDetail() {
    }

    @PostMapping("")
    public void authorCreatePost() {
    }

    @DeleteMapping("")
    public void authorDeletePost() {
    }
}
