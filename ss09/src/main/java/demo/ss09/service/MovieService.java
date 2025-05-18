package demo.ss09.service;

import demo.ss09.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
}

