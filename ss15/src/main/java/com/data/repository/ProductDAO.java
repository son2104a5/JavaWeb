package com.data.repository;

import com.data.model.ProductB6;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<ProductB6> rowMapper = (rs, rowNum) -> {
        ProductB6 p = new ProductB6();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setDescription(rs.getString("description"));
        p.setPrice(rs.getDouble("price"));
        return p;
    };

    public List<ProductB6> findAll() {
        return jdbcTemplate.query("SELECT * FROM product", rowMapper);
    }

    public ProductB6 findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?", rowMapper, id);
    }
}
