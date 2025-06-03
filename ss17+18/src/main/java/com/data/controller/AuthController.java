package com.data.controller;

import com.data.model.Customer;
import com.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("customer") @Valid Customer customer,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if (customerRepo.findByUsername(customer.getUsername()) != null) {
            return "register";
        }

        customerRepo.save(customer);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("customer") Customer customer,
                               HttpSession session, Model model) {
        Customer found = customerRepo.login(customer.getUsername(), customer.getPassword());

        if (found == null) {
            return "login";
        }

        if (!found.isStatus()) {
            return "login";
        }

        session.setAttribute("currentUser", found);

        if ("ADMIN".equalsIgnoreCase(found.getRole())) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("customer", found);
            return "redirect:/home";
        }
    }

}
