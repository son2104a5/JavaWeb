package demo.ss09.service;

import demo.ss09.dao.MovieDAO;
import demo.ss09.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieDAO.findById(id);
    }
}

