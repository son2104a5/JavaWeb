package com.data.model;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private int idUser;
    private String recipientName;
    private String address;
    private String phoneNumber;
}
