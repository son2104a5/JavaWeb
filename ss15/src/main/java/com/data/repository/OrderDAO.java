package com.data.repository;

import com.data.model.Order;
import com.data.model.OrderDetail;
import com.data.model.ProductB6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addOrder(Order order) {
        String sql = "INSERT INTO orders(id_user, recipient_name, address, phone_number) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getIdUser(), order.getRecipientName(), order.getAddress(), order.getPhoneNumber());

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }

    public void addOrderDetails(int orderId, List<OrderDetail> details) {
        String sql = "INSERT INTO order_details(order_id, product_id, quantity, current_price) VALUES (?, ?, ?, ?)";
        for (OrderDetail d : details) {
            jdbcTemplate.update(sql, orderId, d.getProductId(), d.getQuantity(), d.getCurrentPrice());
        }
    }

    public List<Order> getOrdersByUser(int userId) {
        String sql = "SELECT * FROM orders WHERE id_user = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Order.class));
    }

    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        String sql = "SELECT od.*, p.name, p.image, p.price FROM order_details od " +
                "JOIN product_b6 p ON od.product_id = p.id WHERE od.order_id = ?";
        return jdbcTemplate.query(sql, new Object[]{orderId}, (rs, rowNum) -> {
            OrderDetail od = new OrderDetail();
            od.setId(rs.getInt("id"));
            od.setOrderId(rs.getInt("order_id"));
            od.setProductId(rs.getInt("product_id"));
            od.setQuantity(rs.getInt("quantity"));
            od.setCurrentPrice(rs.getDouble("current_price"));

            ProductB6 p = new ProductB6();
            p.setId(rs.getInt("product_id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            return od;
        });
    }
}
