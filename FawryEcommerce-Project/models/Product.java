package models;

import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private boolean hasExpiryDate;
    private LocalDate expiryDate;

    private boolean shippable;
    private double weight;

    public Product(String name, double price, int quantity,
                   boolean hasExpiryDate, LocalDate expiryDate,
                   boolean shippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.hasExpiryDate = hasExpiryDate;
        this.expiryDate = expiryDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public boolean isExpired() {
        return hasExpiryDate && expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }
    
    public boolean isShippable() { return shippable; }
    public double getWeight() { return weight; }
    
    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock for " + name);
        }
        this.quantity -= amount;
    }
}