package demo.ss09.dao;

import demo.ss09.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> findAll();
    Movie findById(Long id);
}
