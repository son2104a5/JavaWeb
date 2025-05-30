package com.data.controller;

import com.data.model.ProductB6;
import com.data.model.Review;
import com.data.service.ProductService;
import com.data.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class B6Controller {
    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "b6+7+8+9/listProduct";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        ProductB6 product = productService.findById(id);
        List<Review> reviews = reviewService.getByProductId(id);

        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        model.addAttribute("newReview", new Review());
        return "b6+7+8+9/productDetail";
    }

    @PostMapping("/{id}/review")
    public String addReview(@PathVariable Long id,
                            @ModelAttribute("newReview") Review review,
                            @RequestParam("userId") Long userId) {
        review.setIdProduct(id);
        review.setIdUser(userId);
        reviewService.save(review);
        return "redirect:/products/" + id;
    }
}
