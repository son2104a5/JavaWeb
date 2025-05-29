package com.app.controller;

import com.app.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class ProductController {

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/products")
    public String showForm(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("product", new Product());
        model.addAttribute("productList", getProductsFromCookie(request));
        return "b2/productForm";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Product> products = getProductsFromCookie(request);
        products.add(product);

        String json = URLEncoder.encode(mapper.writeValueAsString(products), "UTF-8");
        Cookie cookie = new Cookie("products", json);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Product> products = getProductsFromCookie(request);
        products.removeIf(p -> p.getId().equals(id));

        String json = URLEncoder.encode(mapper.writeValueAsString(products), "UTF-8");
        Cookie cookie = new Cookie("products", json);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "redirect:/products";
    }

    private List<Product> getProductsFromCookie(HttpServletRequest request) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return new ArrayList<>();
        for (Cookie cookie : cookies) {
            if ("products".equals(cookie.getName())) {
                String json = URLDecoder.decode(cookie.getValue(), "UTF-8");
                return mapper.readValue(json, new TypeReference<List<Product>>() {});
            }
        }
        return new ArrayList<>();
    }
}
