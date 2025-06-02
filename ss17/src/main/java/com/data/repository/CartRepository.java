package com.data.repository;

import com.data.model.Cart;
import com.data.model.CartItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartRepository {
    @PersistenceContext
    private EntityManager em;

    public Cart findByCustomerId(Long customerId) {
        String jpql = "SELECT c FROM Cart c WHERE c.customer.id = :customerId";
        List<Cart> results = em.createQuery(jpql, Cart.class)
                               .setParameter("customerId", customerId)
                               .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public void save(Cart cart) {
        em.persist(cart);
    }

    public void update(Cart cart) {
        em.merge(cart);
    }

    public void delete(Cart cart, int itemId) {
        CartItem itemToRemove = null;
        for (CartItem item : cart.getItems()) {
            if (item.getId() == itemId) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            cart.getItems().remove(itemToRemove);
            em.remove(itemToRemove);
            em.merge(cart);
        }
    }
}
