package com.data.repository;

import com.data.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }
}
