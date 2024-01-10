package com.local.library.controller;

import com.local.library.domain.GenreRepository;
import com.local.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    private Iterable<Genre> listGenresOrderByName() {
        return genreRepository.findAllOrderByName();
    }
}
