package com.data.repository;

import com.data.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers(int page, int size);
    long countUsers();
    User getUserById(Long id);
    void updateUser(User user);
}
