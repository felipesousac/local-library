package com.local.library.controller;

import com.local.library.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public void authorList() {
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

    @GetMapping("/count")
    public long authorCount() {
        return authorRepository.count();
    }
}
