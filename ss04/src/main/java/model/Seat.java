package model;

public class Seat {
    private String code;
    private String name;
    private int price;
    private boolean booked;

    public Seat(String code, String name, int price, boolean booked) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.booked = booked;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public boolean isBooked() { return booked; }
}
