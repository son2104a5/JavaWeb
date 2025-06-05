package com.data.service;

import com.data.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    void save(Movie movie);
    void deleteOrDisable(Long id);
}
