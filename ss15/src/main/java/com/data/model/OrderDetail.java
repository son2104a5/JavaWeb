package com.data.model;

import lombok.Data;

@Data
public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double currentPrice;
}
