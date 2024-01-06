package com.local.library.controller;

import com.local.library.domain.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/count")
    public long genreCount() {
        return genreRepository.count();
    }
}
