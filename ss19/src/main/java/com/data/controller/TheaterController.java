package com.data.controller;

import com.data.model.Theater;
import com.data.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("theaters", theaterService.getAllTheaters());
        return "theater/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "theater/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("theater") @Valid Theater theater,
                       BindingResult result) {
        if (result.hasErrors()) return "theater/form";
        theaterService.save(theater);
        return "redirect:/admin/theaters";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("theater", theaterService.getTheaterById(id));
        return "theater/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        theaterService.deleteOrDisable(id);
        return "redirect:/admin/theaters";
    }
}
