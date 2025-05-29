package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "b1/login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User authenticated = userService.checkLogin(user.getUsername(), user.getPassword());

        if (authenticated != null) {
            session.setAttribute("loggedInUser", authenticated);
            return "redirect:/welcome";
        }

        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
        return "b1/login";
    }

    @GetMapping("/welcome")
    public String welcomePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", user.getUsername());
        return "b1/welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

