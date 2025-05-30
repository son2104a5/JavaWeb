// com.data.model.Product
package com.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductB6 {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public double getTotalPrice() {
        return price * quantity;
    }
}
