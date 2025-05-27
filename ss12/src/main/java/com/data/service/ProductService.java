package com.data.service;

import com.data.dto.ProductDTO;
import com.data.model.Product;

import java.util.List;

public interface ProductService {
    void add(ProductDTO dto);
    void update(ProductDTO dto);
    void delete(int id);
    ProductDTO findById(int id);
    List<ProductDTO> findAll();
}
