package core;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> myShoppingList = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isExpired()) {
            throw new IllegalStateException("Sorry, this product is expired: " + product.getName());
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough items in stock for: " + product.getName());
        }
        myShoppingList.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return myShoppingList; }
    
    public double getSubtotal() {
        return myShoppingList.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
    
    public boolean isEmpty() { return myShoppingList.isEmpty(); }
}