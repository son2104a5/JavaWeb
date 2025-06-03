package com.data.controller;

import com.data.model.Customer;
import com.data.model.Product;
import com.data.repository.CustomerRepository;
import com.data.repository.OrderRepository;
import com.data.repository.ProductRepository;
import com.data.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CustomerRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CloudinaryService cloudinaryService;

    int size = 5;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Customer current = (Customer) session.getAttribute("currentUser");
        if (current == null || !current.getRole().equals("ADMIN")) {
            return "redirect:/auth/login";
        }

        model.addAttribute("userCount", userRepo.count());
        model.addAttribute("productCount", productRepo.count());
        model.addAttribute("orderCount", orderRepo.count());
        model.addAttribute("revenue", orderRepo.totalRevenue());

        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String viewUsers(Model model,
                        @RequestParam(value = "kw", defaultValue = "") String keyword,
                        @RequestParam(value = "page", defaultValue = "1") int page) {
        List<Customer> users = userRepo.getCustomers(keyword, page, size);
        long totalUsers = userRepo.countCustomers(keyword);
        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);

        return "admin/users";
    }

    @PostMapping("users/lock/{id}")
    public String lockUser(@PathVariable Long id) {
        userRepo.updateStatus(id, false);
        return "redirect:/admin/users";
    }

    @PostMapping("users/unlock/{id}")
    public String unlockUser(@PathVariable Long id) {
        userRepo.updateStatus(id, true);
        return "redirect:/admin/users";
    }

    @GetMapping("users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        Customer customer = userRepo.findById(id);
        if (customer == null) {
            return "redirect:/admin/users";
        }
        model.addAttribute("customer", customer);
        return "admin/user-form";
    }

    @PostMapping("users/edit")
    public String editSubmit(@ModelAttribute("customer") Customer customer) {
        Customer existing = userRepo.findById(customer.getId());
        if (existing != null) {
            existing.setUsername(customer.getUsername());
            existing.setEmail(customer.getEmail());
            existing.setPhoneNumber(customer.getPhoneNumber());
            existing.setRole(customer.getRole());
            userRepo.updateCustomer(existing);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/products")
    public String viewProducts(HttpSession session, Model model,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "keyword", required = false) String keyword) {
        Customer current = (Customer) session.getAttribute("currentUser");
        if (current == null || !current.getRole().equals("ADMIN")) {
            return "redirect:/auth/login";
        }

        long totalItems = productRepo.countByKeyword(keyword);
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("products", productRepo.search(keyword, page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);

        return "admin/products";
    }


    @GetMapping("/products/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/product-form";
    }


    @PostMapping("/products/create")
    public String create(@Valid @ModelAttribute Product product,
                         BindingResult result,
                         @RequestParam("imageFile") MultipartFile file) throws IOException {
        if (result.hasErrors()) return "admin/product-form";

        if (!file.isEmpty()) {
            String imageUrl = cloudinaryService.uploadFile(file);
            product.setImage(imageUrl);
        }

        productRepo.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product p = productRepo.findById(id);
        model.addAttribute("product", p);
        return "admin/product-form";
    }

    @PostMapping("/products/edit")
    public String update(@Valid @ModelAttribute Product product,
                         BindingResult result,
                         @RequestParam("imageFile") MultipartFile file) throws IOException {
        if (result.hasErrors()) return "admin/product-form";

        if (!file.isEmpty()) {
            String imageUrl = cloudinaryService.uploadFile(file);
            product.setImage(imageUrl);
        }

        productRepo.update(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable Long id) {
        Product product = productRepo.findById(id);
        if (product != null) {
            productRepo.delete(product);
        }
        return "redirect:/admin/products";
    }

    @GetMapping("/orders")
    public String viewOrders(HttpSession session, Model model,
                             @RequestParam(value = "page", defaultValue = "1") int page) {
        Customer current = (Customer) session.getAttribute("currentUser");
        if (current == null || !current.getRole().equals("ADMIN")) {
            return "redirect:/auth/login";
        }

        long totalItems = orderRepo.count();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("orders", orderRepo.findOrders(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalPrices", orderRepo.totalRevenueByCustomer(current.getId()));
        return "admin/orders";
    }
}
