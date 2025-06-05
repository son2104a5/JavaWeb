package com.data.service;

import com.data.model.User;
import com.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(int page, int size) {
        return userRepository.getUsers(page, size);
    }

    public long getUserCount() {
        return userRepository.countUsers();
    }

    public void toggleUserStatus(Long id) {
        User user = userRepository.getUserById(id);
        if (user != null) {
            user.setIsActive(!user.getIsActive());
            userRepository.updateUser(user);
        }
    }
}
