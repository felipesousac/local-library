package com.local.library.domain;

import com.local.library.model.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {

    @Query("select count(*) from Bookinstance WHERE status = 'ACTIVE'")
    long activeBookInstancesCount();

    @Query("select b, a.title from Bookinstance b inner join Book a on (b.bookid = a.id)")
    Iterable<BookInstance> findBookinstanceWithBookNames();

    // select b.*, a.title from bookinstances as b inner join books as a on (b.bookid = a.id);

    // @Query("select b, a.firstname, a.lastname from Book b inner join Author a on (b.authorid = a.id)")
}
