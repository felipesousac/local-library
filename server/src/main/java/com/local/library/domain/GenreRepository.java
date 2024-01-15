package com.local.library.domain;

import com.local.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select a, b from Book a join Genre b on a.genreid = b.id where a.genreid = :id")
    Iterable<Genre> findBooksByGenreId(Long id);
}
