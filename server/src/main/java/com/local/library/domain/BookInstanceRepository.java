package com.local.library.domain;

import com.local.library.model.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {

    @Query("select count(*) from Bookinstance WHERE status = 'ACTIVE'")
    long activeBookInstancesCount();
}
