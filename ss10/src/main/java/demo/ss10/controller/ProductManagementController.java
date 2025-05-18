package demo.ss10.controller;

import demo.ss10.model.Product;
import demo.ss10.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductManagementController {

    private final CloudinaryService cloudinaryService;
    private final List<Product> products = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", products);
        return "B10/productList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "B10/productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) throws IOException {
        if (product.getImageFile() != null && !product.getImageFile().isEmpty()) {
            String url = cloudinaryService.uploadFile(product.getImageFile());
            product.setImage(url);
        }

        product.setId(idCounter++);
        products.add(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product p = products.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        model.addAttribute("product", p);
        return "B10/productForm";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) throws IOException {
        Product existing = products.stream().filter(x -> x.getId() == product.getId()).findFirst().orElse(null);
        if (existing != null) {
            if (product.getImageFile() != null && !product.getImageFile().isEmpty()) {
                String url = cloudinaryService.uploadFile(product.getImageFile());
                product.setImage(url);
            } else {
                product.setImage(existing.getImage());
            }
            products.remove(existing);
            products.add(product);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
        return "redirect:/products";
    }
}
