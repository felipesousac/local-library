package com.local.library.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog/authors")
public class AuthorController {

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
}
