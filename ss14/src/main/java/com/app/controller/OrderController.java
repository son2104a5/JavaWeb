package com.app.controller;

import com.app.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String listOrders(Model model, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) orders = new ArrayList<>();
        model.addAttribute("orders", orders);
        return "b5/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Order());
        return "b5/add";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute("order") Order order, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) orders = new ArrayList<>();
        orders.add(order);
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("code") String code, HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            for (Order o : orders) {
                if (o.getOrderCode().equals(code)) {
                    model.addAttribute("order", o);
                    break;
                }
            }
        }
        return "b5/edit";
    }

    @PostMapping("/edit")
    public String updateOrder(@ModelAttribute("order") Order updatedOrder, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getOrderCode().equals(updatedOrder.getOrderCode())) {
                    orders.set(i, updatedOrder);
                    break;
                }
            }
        }
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }

    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("code") String code, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            orders.removeIf(o -> o.getOrderCode().equals(code));
        }
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }
}
