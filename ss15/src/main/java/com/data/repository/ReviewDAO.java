package com.data.repository;

import com.data.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAO {

    private final JdbcTemplate jdbcTemplate;

    public ReviewDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Review> rowMapper = (rs, rowNum) -> {
        Review r = new Review();
        r.setId(rs.getLong("id"));
        r.setIdProduct(rs.getLong("product_id"));
        r.setIdUser(rs.getLong("user_id"));
        r.setRating(rs.getInt("rating"));
        r.setComment(rs.getString("comment"));
        return r;
    };

    public List<Review> findByProductId(Long productId) {
        String sql = "SELECT * FROM review WHERE product_id = ?";

        return jdbcTemplate.query(sql, rowMapper, productId);
    }

    public void save(Review review) {
        String sql = "INSERT INTO review(product_id, user_id, rating, comment) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                review.getIdProduct(),
                review.getIdUser(),
                review.getRating(),
                review.getComment());
    }
}
