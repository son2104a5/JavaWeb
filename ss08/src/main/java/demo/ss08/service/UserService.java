package demo.ss08.service;

import demo.ss08.model.UserGame;
import demo.ss08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    UserGame findByUsername(String username);

    void updateUser(UserGame user);
}


