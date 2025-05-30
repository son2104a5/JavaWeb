package com.data.service;

import com.data.repository.ProductDAO;
import com.data.model.ProductB6;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductB6> findAll() {
        return productDAO.findAll();
    }

    public ProductB6 findById(Long id) {
        return productDAO.findById(id);
    }
}
