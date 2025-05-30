package com.data.service;

import com.data.model.Cart;
import com.data.model.ProductB6;
import com.data.repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDAO cartDAO;

    public void addToCart(int userId, int productId, int quantity) {
        cartDAO.addToCart(userId, productId, quantity);
    }

    public List<ProductB6> getCartList(int userId) {
        return cartDAO.getCartItems(userId);
    }

    public double getTotalPrice(int userId) {
        return cartDAO.getTotalPrice(userId);
    }
}
