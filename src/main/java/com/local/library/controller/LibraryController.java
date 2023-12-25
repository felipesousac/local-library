package com.local.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping("/users/cool")
    public String helloCool() {
        return "hello";
    }
}
