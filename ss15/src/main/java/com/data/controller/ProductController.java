package com.data.controller;

import com.data.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    private static final List<Product> productList = Arrays.asList(
            new Product("P001", "iPhone 15", 1200),
            new Product("P002", "Samsung S23", 1000),
            new Product("P003", "Xiaomi 13", 800)
    );

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("keyword", "");
        model.addAttribute("results", new ArrayList<Product>());
        return "b5/searchForm";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Product> results = new ArrayList<>();
        if (keyword != null && !keyword.trim().isEmpty()) {
            for (Product p : productList) {
                if (p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        p.getCode().equalsIgnoreCase(keyword)) {
                    results.add(p);
                }
            }
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("results", results);
        model.addAttribute("error", keyword.trim().isEmpty());
        return "b5/searchForm";
    }
}
