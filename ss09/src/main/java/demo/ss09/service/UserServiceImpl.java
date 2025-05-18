package demo.ss09.service;

import demo.ss09.dao.UserDAO;
import demo.ss09.model.User;
import demo.ss09.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User checkLogin(String username, String password) {
        return userDAO.checkLogin(username, password);
    }
}
