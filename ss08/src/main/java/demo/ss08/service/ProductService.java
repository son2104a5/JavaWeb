package demo.ss08.service;

import demo.ss08.model.Product;
import demo.ss08.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(productRepository.findAll());
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        // Auto tăng id (đơn giản)
        int newId = productList.size() + 1;
        product.setId(newId);
        productList.add(product);
    }
}
