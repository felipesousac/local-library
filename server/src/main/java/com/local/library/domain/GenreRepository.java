package com.local.library.domain;

import com.local.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select a from Genre a order by a.name")
    Iterable<Genre> findAllOrderByName();
}
