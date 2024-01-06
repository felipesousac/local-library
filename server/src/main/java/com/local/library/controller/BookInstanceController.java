package com.local.library.controller;

import com.local.library.domain.BookInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/bookinstance")
public class BookInstanceController {

    @Autowired
    private BookInstanceRepository bookInstanceRepository;

    @GetMapping("/count")
    public long bookInstanceCount() {
        return bookInstanceRepository.count();
    }

    @GetMapping("/count/available")
    public long bookInstanceAvailableCount() {
        return bookInstanceRepository.activeBookInstancesCount();
    }
}
