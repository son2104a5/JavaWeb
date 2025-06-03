package com.data.repository;

import com.data.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public Customer findByUsername(String username) {
        String jpql = "SELECT c FROM Customer c WHERE c.username = :username";
        List<Customer> result = em.createQuery(jpql, Customer.class)
                                  .setParameter("username", username)
                                  .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public Customer login(String username, String password) {
        String jpql = "SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password";
        List<Customer> result = em.createQuery(jpql, Customer.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

}
