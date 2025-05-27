package com.data.service;

import com.data.dto.ProductDTO;
import com.data.model.Product;
import com.data.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    public void add(ProductDTO dto) {
        Product p = new Product(0, dto.getName(), dto.getPrice(), dto.getQuantity(), dto.getImage());
        dao.add(p);
    }

    @Override
    public void update(ProductDTO dto) {
        Product p = new Product(dto.getId(), dto.getName(), dto.getPrice(), dto.getQuantity(), dto.getImage());
        dao.update(p);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public ProductDTO findById(int id) {
        Product p = dao.findById(id);
        return new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getQuantity(), null, p.getImage());
    }

    @Override
    public List<ProductDTO> findAll() {
        return dao.findAll().stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getQuantity(), null, p.getImage()))
                .collect(Collectors.toList());
    }
}
