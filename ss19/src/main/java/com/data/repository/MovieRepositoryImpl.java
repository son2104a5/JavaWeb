package com.data.repository;

import com.data.model.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> getMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class)
                 .getResultList();
    }

    @Override
    public Movie getMovieById(Long id) {
        return em.find(Movie.class, id);
    }

    @Override
    public void addOrUpdateMovie(Movie movie) {
        if (movie.getId() == null) {
            em.persist(movie);
        } else {
            em.merge(movie);
        }
    }

    @Override
    public void deleteMovie(Movie movie) {
        Movie existingMovie = em.find(Movie.class, movie.getId());
        if (existingMovie != null) {
            em.remove(existingMovie);
        }
    }

//    @Override
//    public boolean hasSchedule(Long movieId) {
//        Long count = em.createQuery("SELECT COUNT(s) FROM Schedule s WHERE s.movie.id = :movieId", Long.class)
//                       .setParameter("movieId", movieId)
//                       .getSingleResult();
//        return count > 0;
//    }
}
