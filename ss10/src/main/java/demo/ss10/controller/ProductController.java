package demo.ss10.controller;

import demo.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ProductController {

    @GetMapping("/product-form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "B2/productForm";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        model.addAttribute("submittedProduct", product);
        return "B2/productResult";
    }


}
