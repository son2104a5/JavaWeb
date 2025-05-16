package demo.ss09.service;

import demo.ss09.model.User;

public interface UserService {
    User checkLogin(String username, String password);
}

