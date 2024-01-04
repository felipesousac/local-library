package com.local.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class LibraryController {

    private ArrayList<Object> messages = new ArrayList<>();

    @GetMapping("/users/cool")
    public String helloCool() {
        return "hello";
    }
}
