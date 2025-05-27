package com.data.repository;

import com.data.model.Product;
import java.util.List;

public interface ProductDAO {
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
}
