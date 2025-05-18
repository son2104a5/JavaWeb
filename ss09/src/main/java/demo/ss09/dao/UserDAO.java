package demo.ss09.dao;

import demo.ss09.model.User;

public interface UserDAO {
    User checkLogin(String username, String password);
}
