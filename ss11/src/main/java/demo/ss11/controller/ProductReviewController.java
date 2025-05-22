package demo.ss11.controller;

import demo.ss11.model.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductReviewController {

    @GetMapping("/review")
    public String showReviewForm(Model model) {
        model.addAttribute("productReview", new ProductReview());
        return "b7/reviewForm";
    }

    @PostMapping("/review")
    public String submitReview(@ModelAttribute("productReview") @Valid ProductReview review,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "b7/reviewForm";
        }

        model.addAttribute("message", "Cảm ơn bạn đã đánh giá!");
        return "b7/reviewSuccess";
    }
}
