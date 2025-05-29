package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LanguageController {

    @GetMapping("/home")
    public String showHomePage() {
        return "b3/home";
    }

    @PostMapping("/change-language")
    public String changeLanguage(@RequestParam("lang") String lang,
                                 HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "redirect:/home";
    }
}

