package demo.ss11.controller;

import demo.ss11.model.Account;
import demo.ss11.validator.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import javax.validation.groups.Default;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterGroupController {

    @Autowired
    private SmartValidator validator;

    @GetMapping("/register-group")
    public String showForm(Model model) {
        model.addAttribute("account", new Account());
        return "b5/registerForm";
    }

    @PostMapping("/register-group")
    public String processForm(@ModelAttribute("account") Account account,
                              BindingResult result,
                              Model model) {

        Class<?> group = account.getRole() != null && account.getRole().equalsIgnoreCase("admin")
                ? Validation.AdminGroup.class
                : Validation.UserGroup.class;

        validator.validate(account, result, group, Default.class);

        if (result.hasErrors()) {
            return "b5/registerForm";
        }

        model.addAttribute("account", account);
        return "b5/registerSuccess";
    }
}
