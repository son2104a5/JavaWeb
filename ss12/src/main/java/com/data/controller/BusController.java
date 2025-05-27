package com.data.controller;

import com.data.dto.BusDTO;
import com.data.model.Bus;
import com.data.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public String listBuses(Model model) {
        model.addAttribute("buses", busService.findAll());
        return "b3/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bus", new BusDTO());
        return "b3/add";
    }

    @PostMapping("/add")
    public String addBus(@Valid @ModelAttribute("bus") BusDTO busDTO,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "b3/add";
        }
        busService.save(busDTO);
        return "redirect:/buses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Bus bus = busService.findById(id);
        model.addAttribute("bus", bus);
        return "b3/edit";
    }

    @PostMapping("/edit")
    public String updateBus(@Valid @ModelAttribute("bus") BusDTO busDTO,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "b3/edit";
        }
        busService.update(busDTO);
        return "redirect:/buses";
    }

    @GetMapping("/delete/{id}")
    public String deleteBus(@PathVariable int id) {
        busService.delete(id);
        return "redirect:/buses";
    }
}
