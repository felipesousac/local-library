package com.local.library.service;

import com.local.library.domain.GenreRepository;
import com.local.library.dto.CreateGenreData;
import com.local.library.infra.exception.AlreadyCreatedException;
import com.local.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public ResponseEntity createGenre(CreateGenreData data, UriComponentsBuilder uriBuilder) throws AlreadyCreatedException {
        Genre genre = new Genre(data);

        Genre checker = genreRepository.findByName(genre.getName());

        if (checker != null) {
            throw new AlreadyCreatedException("The genre '" + genre.getName() + "' already exists", checker.getId());
        }

        genreRepository.save(genre);

        URI uri = uriBuilder.path("/catalog/genres/detail/{id}").buildAndExpand(genre.getId()).toUri();

        return ResponseEntity.created(uri).body(genre);
    }
}
