package core;

public class Customer {
    private String name;
    private double availableMoney;

    public Customer(String name, double availableMoney) {
        this.name = name;
        this.availableMoney = availableMoney;
    }

    public String getName() { return name; }
    public double getBalance() { return availableMoney; }
    
    public void deductBalance(double amount) {
        if (amount > availableMoney) {
            throw new IllegalArgumentException("Not enough money in wallet!");
        }
        availableMoney -= amount;
    }
}