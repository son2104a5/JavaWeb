package demo.ss08.repository;

import demo.ss08.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "iPhone 15", 10, 999),
                new Product(2, "Samsung S24", 20, 899),
                new Product(3, "Xiaomi 13", 5, 499)
        );
    }
}
