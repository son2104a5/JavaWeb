package com.data.repository;

import com.data.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public void save(Product product) {
        em.persist(product);
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void delete(Product product) {
        if (em.contains(product)) {
            em.remove(product);
        } else {
            Product managedProduct = em.find(Product.class, product.getId());
            if (managedProduct != null) {
                em.remove(managedProduct);
            }
        }
    }

    public List<Product> search(String keyword, int page, int size) {
        String jpql = "SELECT p FROM Product p WHERE p.productName LIKE :kw";
        return em.createQuery(jpql, Product.class)
                .setParameter("kw", "%" + (keyword == null ? "" : keyword) + "%")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public long countByKeyword(String keyword) {
        String jpql = "SELECT COUNT(p) FROM Product p WHERE p.productName LIKE :kw";
        return em.createQuery(jpql, Long.class)
                .setParameter("kw", "%" + (keyword == null ? "" : keyword) + "%")
                .getSingleResult();
    }

}
