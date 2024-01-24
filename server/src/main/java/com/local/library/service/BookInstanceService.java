package com.local.library.service;

import com.local.library.domain.BookInstanceRepository;
import com.local.library.domain.BookRepository;
import com.local.library.dto.BookInstanceDetail;
import com.local.library.model.Book;
import com.local.library.model.BookInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookInstanceService {

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<BookInstanceDetail> findBookInstanceWithBookName(Long id) {
        BookInstance bookInstance = bookInstanceRepository.getReferenceById(id);
        Book book = bookRepository.getReferenceById(bookInstance.getBookid());

        return ResponseEntity.ok(new BookInstanceDetail(bookInstance, book));
    }
}
