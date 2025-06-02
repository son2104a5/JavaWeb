package com.data.repository;

import com.data.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Product> findProducts(int page, int size) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long countProducts() {
        return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }
}
