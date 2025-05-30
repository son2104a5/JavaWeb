package com.data.controller;

import com.data.model.Order;
import com.data.model.OrderDetail;

import com.data.model.ProductB6;
import com.data.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderDAO orderRepo;

    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession session) {
        List<ProductB6> cart = (List<ProductB6>) session.getAttribute("cart");
        model.addAttribute("cartItems", cart);
        model.addAttribute("order", new Order());
        return "b6+7+8+9/checkout";
    }

    @PostMapping("/checkout/add")
    public String placeOrder(@ModelAttribute("order") Order order, HttpSession session) {
        List<ProductB6> cart = (List<ProductB6>) session.getAttribute("cart");

        int orderId = orderRepo.addOrder(order);

        List<OrderDetail> details = new ArrayList<>();
        for (ProductB6 item : cart) {
            OrderDetail d = new OrderDetail();
            d.setOrderId(orderId);
            d.setProductId(item.getId());
            d.setQuantity(item.getQuantity());
            d.setCurrentPrice(item.getTotalPrice());
            details.add(d);
        }

        orderRepo.addOrderDetails(orderId, details);
        session.removeAttribute("cart");
        return "redirect:/products";
    }

    @GetMapping("/orders")
    public String listOrders(@RequestParam(defaultValue = "1") int userId, Model model) {
        List<Order> orders = orderRepo.getOrdersByUser(userId);
        model.addAttribute("orders", orders);
        return "b6+7+8+9/list";
    }

    @GetMapping("/order/{id}")
    public String viewOrderDetails(@PathVariable("id") int orderId, Model model) {
        Order order = orderRepo.getOrderById(orderId);
        List<OrderDetail> details = orderRepo.getOrderDetailsByOrderId(orderId);

        model.addAttribute("order", order);
        model.addAttribute("details", details);
        return "b6+7+8+9/detail";
    }
}
