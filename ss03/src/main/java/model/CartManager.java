package model;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : cart) {
            if (p.getId() == product.getId()) return; // đã tồn tại
        }
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void removeProduct(int id) {
        cart.removeIf(p -> Integer.parseInt(p.getId()) == id);
    }

    public double getTotalPrice() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }
}
