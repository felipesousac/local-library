package com.local.library.service;

import com.local.library.domain.AuthorRepository;
import com.local.library.domain.BookRepository;
import com.local.library.dto.AuthorDetail;
import com.local.library.model.Author;
import com.local.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<AuthorDetail> authorDetailData(Long id) {
        Author author = authorRepository.getReferenceById(id);
        List<Book> books = bookRepository.findBooksByAuthorId(author.getId());

        return ResponseEntity.ok(new AuthorDetail(author, books));
    }
}
