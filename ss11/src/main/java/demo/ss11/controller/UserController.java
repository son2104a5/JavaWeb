package demo.ss11.controller;

import demo.ss11.model.UserB1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user-form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserB1());
        return "b1/userForm";
    }

    @PostMapping("/user-form")
    public String submitForm(@ModelAttribute("user") @Valid UserB1 user,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "b1/userForm";
        }
        model.addAttribute("user", user);
        return "b1/userSuccess";
    }
}
