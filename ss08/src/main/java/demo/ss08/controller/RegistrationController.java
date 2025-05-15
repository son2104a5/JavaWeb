package demo.ss08.controller;

import demo.ss08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, BindingResult result, Model model, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        validateUser(user, result);

        if (result.hasErrors()) {
            return "registration";
        }
        model.addAttribute("user", user);
        return "result";
    }

    private void validateUser(User user, BindingResult result) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            result.rejectValue("name", "name.empty", "Tên không được để trống");
        }

        if (user.getEmail() == null || !isValidEmail(user.getEmail())) {
            result.rejectValue("email", "email.invalid", "Email không hợp lệ");
        }

        if (user.getPhone() == null || !isValidPhone(user.getPhone())) {
            result.rejectValue("phone", "phone.invalid", "Số điện thoại không hợp lệ");
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.\\w+$";
        return Pattern.matches(regex, email);
    }

    private boolean isValidPhone(String phone) {
        String regex = "^\\d{9,11}$"; // từ 9 đến 11 số
        return Pattern.matches(regex, phone);
    }
}
