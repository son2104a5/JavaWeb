package com.data.controller;

import com.data.model.Movie;
import com.data.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("movie") @Valid Movie movie,
                       BindingResult result) {
        if (result.hasErrors()) return "movie/form";
        movieService.save(movie);
        return "redirect:/admin/movies";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieService.deleteOrDisable(id);
        return "redirect:/admin/movies";
    }
}
