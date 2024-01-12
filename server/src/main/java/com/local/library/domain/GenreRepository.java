package com.local.library.domain;

import com.local.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select a from Genre a order by a.name")
    Iterable<Genre> findAllOrderByName();


    @Query("select a, b.name from Book a join Genre b on a.genreid = b.id where a.genreid = :id")
    Iterable<Genre> findBooksByGenreId(Long id);

//
//    SELECT a.*, b.name
//    FROM tbBooks AS a
//    INNER JOIN tbGenres AS b ON a.genreId = b.id
//    WHERE a.genreId = 4;
}
