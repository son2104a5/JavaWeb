package com.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/home")
    public String home() {
        return "b4/home";
    }

    @GetMapping("/about")
    public String about() {
        return "b4/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "b4/contact";
    }

}
