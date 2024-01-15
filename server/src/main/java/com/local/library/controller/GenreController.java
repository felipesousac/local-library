package com.local.library.controller;

import com.local.library.domain.GenreRepository;
import com.local.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    private ResponseEntity<Page<Genre>> listGenresOrderByName(@PageableDefault(size = 15, sort = {"name"}) Pageable pagination) {
        return ResponseEntity.ok(genreRepository.findAll(pagination));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Iterable<Genre>> genreDetail(@PathVariable Long id) {
        return ResponseEntity.ok(genreRepository.findBooksByGenreId(id));
    };
}
