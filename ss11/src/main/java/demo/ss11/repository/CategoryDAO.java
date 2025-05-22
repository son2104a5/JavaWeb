package demo.ss11.repository;

import demo.ss11.model.Category;
import java.util.List;

public interface CategoryDAO {
    void save(Category category);
    List<Category> findAll();
    boolean existsByName(String name);
    Category findById(int id);
    void update(Category category);
    void delete(int id);
    boolean existsByNameExcludingId(String name, int id);
}
