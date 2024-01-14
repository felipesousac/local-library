package com.local.library.domain;

import com.local.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b, a from Book b inner join Author a on (b.authorid = a.id)")
    Iterable<Book> findBookAndAuthorById();
}
