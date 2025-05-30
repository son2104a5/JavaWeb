package com.data.controller;

import com.data.model.Cart;
import com.data.model.Product;
import com.data.model.ProductB6;
import com.data.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam int productId,
                            @RequestParam int quantity,
                            @RequestParam(defaultValue = "1") int userId) {
        cartService.addToCart(userId, productId, quantity);
        return "redirect:/products";
    }

    @GetMapping
    public String viewCart(@RequestParam(defaultValue = "1") int userId, Model model, HttpSession session) {
        List<ProductB6> cartItems = cartService.getCartList(userId);
        double totalPrice = cartService.getTotalPrice(userId);
        session.setAttribute("cart", cartItems);
        session.setAttribute("userId", userId);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("userId", userId);

        return "b6+7+8+9/cart";
    }
}
