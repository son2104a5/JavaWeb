package demo.ss11.controller;

import demo.ss11.model.Category;
import demo.ss11.service.CategoryService;
import demo.ss11.validator.UniqueCategoryNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UniqueCategoryNameValidator categoryNameValidator;

    @GetMapping("/categories")
    public String showForm(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.findAll());
        return "b8/categoryForm";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute("category") @Valid Category category,
                              BindingResult result,
                              Model model) {
        categoryNameValidator.validate(category, result);

        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "b8/categoryForm";
        }

        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit-category/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryService.findAll());
        return "b8/categoryForm";
    }

    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute("category") @Valid Category category,
                                 BindingResult result,
                                 Model model) {
        // Validate tên không trùng, ngoại trừ chính nó
        if (categoryService.existsByNameExcludingId(category.getCategoryName(), category.getId())) {
            result.rejectValue("categoryName", "error.category", "Tên danh mục đã tồn tại");
        }

        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "b8/categoryForm";
        }

        categoryService.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

}
