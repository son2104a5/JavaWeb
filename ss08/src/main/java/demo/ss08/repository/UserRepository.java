package demo.ss08.repository;

import demo.ss08.model.UserGame;

public interface UserRepository{
    UserGame findByUsername(String username);
    void save(UserGame user);
}
