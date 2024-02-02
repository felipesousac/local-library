package com.local.library.controller;

import com.local.library.domain.AuthorRepository;
import com.local.library.dto.AuthorDetail;
import com.local.library.model.Author;
import com.local.library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/catalog/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<Author>> authorList(@PageableDefault(size = 15, sort = {"lastname"}) Pageable pagination) {
        return ResponseEntity.ok(authorRepository.findAll(pagination));
    }

    @GetMapping("/{id}")
    private ResponseEntity<AuthorDetail> authorDetail(@PathVariable Long id) {
        return authorService.authorDetailData(id);
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity authorName(@PathVariable Long id) {
        return ResponseEntity.ok(authorRepository.findById(id));
    }

    @PostMapping
    private ResponseEntity createAuthor(@RequestBody @Valid Author data, UriComponentsBuilder uriBuilder) {
        return authorService.createAuthor(data, uriBuilder);
    }
}
