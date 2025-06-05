package com.data.repository;

import com.data.model.Theater;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TheaterRepositoryImpl implements TheaterRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Theater> getTheaters() {
        return em.createQuery("SELECT t FROM Theater t", Theater.class)
                 .getResultList();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return em.find(Theater.class, id);
    }

    @Override
    public void saveOrUpdate(Theater theater) {
        if (theater.getId() == null) {
            em.persist(theater);
        } else {
            em.merge(theater);
        }
    }

    @Override
    public void delete(Theater theater) {
        Theater existingTheater = em.find(Theater.class, theater.getId());
        if (existingTheater != null) {
            em.remove(existingTheater);
        }
    }

//    @Override
//    public boolean hasSchedule(Long theaterId) {
//        Long count = em.createQuery("SELECT COUNT(s) FROM Schedule s WHERE s.theater.id = :theaterId", Long.class)
//                       .setParameter("theaterId", theaterId)
//                       .getSingleResult();
//        return count > 0;
//    }
}
