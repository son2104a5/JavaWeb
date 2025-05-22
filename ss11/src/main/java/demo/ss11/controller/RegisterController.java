package demo.ss11.controller;

import demo.ss11.model.UserB2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/register-b2")
    public String showForm(Model model) {
        model.addAttribute("user", new UserB2());
        return "b2/register";
    }

    @PostMapping("/register-b2")
    public String submitForm(@ModelAttribute("user") @Valid UserB2 user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "b2/register";
        }

        model.addAttribute("message", "Đăng ký thành công!");
        return "b2/result";
    }
}
