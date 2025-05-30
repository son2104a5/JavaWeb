package com.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String showHello(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "b1/hello";
    }
}
