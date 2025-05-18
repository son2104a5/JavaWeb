package demo.ss08.service;

import demo.ss08.model.UserGame;
import demo.ss08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserGame findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(UserGame user) {
        userRepository.save(user);
    }
}
