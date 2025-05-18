package demo.ss10.controller;

import demo.ss10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class UserController {

    @GetMapping("/user-form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "B1/userForm";
    }

    @PostMapping("/submit-form")
    public String submitForm(@ModelAttribute("user") User user, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        model.addAttribute("submittedUser", user);
        return "B1/result";
    }
}
