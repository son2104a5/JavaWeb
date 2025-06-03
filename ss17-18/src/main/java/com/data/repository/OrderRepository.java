package com.data.repository;

import com.data.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public int count() {
        String jpql = "SELECT COUNT(o) FROM Order o";
        return em.createQuery(jpql, Long.class).getSingleResult().intValue();
    }

    public double totalRevenue() {
        String jpql = "SELECT SUM(od.unitPrice * od.quantity) FROM OrderDetail od";
        Double total = em.createQuery(jpql, Double.class).getSingleResult();
        return total != null ? total : 0.0;
    }

    public List<Order> findOrders(int page, int size) {
        String jpql = "SELECT o FROM Order o";
        return em.createQuery(jpql, Order.class)
                 .setFirstResult((page - 1) * size)
                 .setMaxResults(size)
                 .getResultList();
    }

    public double totalRevenueByCustomer(Long customerId) {
        String jpql = "SELECT SUM(od.unitPrice * od.quantity) FROM OrderDetail od WHERE od.order.customer.id = :customerId";
        Double total = em.createQuery(jpql, Double.class)
                         .setParameter("customerId", customerId)
                         .getSingleResult();
        return total != null ? total : 0.0;
    }
}
