package com.data.repository;

import com.data.model.ProductB6;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAO {
    private final JdbcTemplate jdbcTemplate;

    public CartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addToCart(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, userId, productId, quantity);
    }

    public List<ProductB6> getCartItems(int userId) {
        String sql = "SELECT p.*, c.quantity FROM cart c JOIN product p ON c.product_id = p.id WHERE c.user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            ProductB6 p = new ProductB6();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));
            return p;
        });
    }

    public double getTotalPrice(int userId) {
        String sql = "SELECT SUM(p.price * c.quantity) FROM cart c JOIN product p ON c.product_id = p.id WHERE c.user_id = ? ";
        Double result = jdbcTemplate.queryForObject(sql, new Object[]{userId}, Double.class);
        return result != null ? result : 0.0;
    }
}
