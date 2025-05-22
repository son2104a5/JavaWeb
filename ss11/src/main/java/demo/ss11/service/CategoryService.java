package demo.ss11.service;

import demo.ss11.model.Category;
import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    boolean existsByName(String name);
    Category findById(int id);
    void update(Category category);
    void delete(int id);
    boolean existsByNameExcludingId(String name, int id);

}
