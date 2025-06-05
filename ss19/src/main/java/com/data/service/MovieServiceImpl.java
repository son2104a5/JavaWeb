package com.data.service;

import com.data.model.Movie;
import com.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.getMovies();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepo.getMovieById(id);
    }

    @Override
    public void save(Movie movie) {
        movieRepo.addOrUpdateMovie(movie);
    }

    @Override
    public void deleteOrDisable(Long id) {
        Movie m = movieRepo.getMovieById(id);
//        if (m != null) {
//            if (movieRepo.hasSchedule(id)) {
//                m.setStatus(false);
//                movieRepo.addOrUpdateMovie(m);
//            } else {
        movieRepo.deleteMovie(m);
//            }
    }
}
