package com.local.library.domain;

import com.local.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a order by a.lastname")
    Iterable<Author> findAllOrderByFamilyName();
}
