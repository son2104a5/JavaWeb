package com.data.repository;

import com.data.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies();
    Movie getMovieById(Long id);
    void addOrUpdateMovie(Movie movie);
    void deleteMovie(Movie movie);
//    boolean hasSchedule(Long movieId);
}
