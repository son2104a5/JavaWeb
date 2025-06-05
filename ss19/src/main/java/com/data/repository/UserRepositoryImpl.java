package com.data.repository;

import com.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsers(int page, int size) {
        return em.createQuery("SELECT u FROM User u", User.class)
                 .setFirstResult((page - 1) * size)
                 .setMaxResults(size)
                 .getResultList();
    }

    @Override
    public long countUsers() {
        return em.createQuery("SELECT COUNT(u) FROM User u", Long.class)
                 .getSingleResult();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = em.find(User.class, user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setIsActive(user.getIsActive());
            em.merge(existingUser);
        }
    }
}
