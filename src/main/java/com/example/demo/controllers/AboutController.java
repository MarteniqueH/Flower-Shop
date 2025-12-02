package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/home")
    public String displayMain() {
        return "mainscreen";
    }

    @GetMapping("/about")
    public String displayAbout() {
        return "about";
    }
}
