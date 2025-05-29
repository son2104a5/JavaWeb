package com.app.service;

import com.app.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User checkLogin(String username, String password) {
        if ("admin".equals(username) && "123".equals(password)) {
            return new User(username, password);
        }
        return null;
    }
}
