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

    public int count() {
        String jpql = "SELECT COUNT(c) FROM Customer c";
        return em.createQuery(jpql, Long.class).getSingleResult().intValue();
    }

    public List<Customer> getCustomers(String keyword, int page, int pageSize) {
        String hql = "FROM Customer WHERE username LIKE :kw ORDER BY id DESC";
        TypedQuery<Customer> query = em.createQuery(hql, Customer.class);
        query.setParameter("kw", "%" + keyword + "%");
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public long countCustomers(String keyword) {
        String hql = "SELECT COUNT(*) FROM Customer WHERE username LIKE :kw";
        TypedQuery<Long> query = em.createQuery(hql, Long.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.getSingleResult();
    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    public void updateStatus(Long id, boolean status) {
        Customer c = findById(id);
        if (c != null) {
            c.setStatus(status);
            em.merge(c);
        }
    }

    public void updateCustomer(Customer customer) {
        Customer existingCustomer = findById(customer.getId());
        if (existingCustomer != null) {
            existingCustomer.setUsername(customer.getUsername());
            existingCustomer.setPassword(customer.getPassword());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            existingCustomer.setStatus(customer.isStatus());
            em.merge(existingCustomer);
        }
    }
}
