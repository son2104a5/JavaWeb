package model;

public class Product {
    private String id;
    private String productName;
    private double price;
    private String description;
    private int stock;
    private String status;

    public Product(String id, String productName, double price, String description, int stock, String status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
    }

    public Product(String id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    // Getters
    public String getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
    public String getStatus() { return status; }
}

