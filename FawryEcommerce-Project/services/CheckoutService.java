package services;

import core.Cart;
import core.CartItem;
import core.Customer;
import models.Product;
import models.Shippable;
import models.ShippableProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private static final double SHIPPING_RATE_PER_KG = 30.0;

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Your cart is empty!");
        }

        double orderTotal = 0;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product.isExpired()) {
                throw new IllegalStateException("Sorry, " + product.getName() + " has expired!");
            }

            orderTotal += item.getTotalPrice();
            product.reduceQuantity(item.getQuantity());

            if (product.isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    itemsToShip.add(new ShippableProductAdapter(product));
                }
            }
        }

        double totalWeight = itemsToShip.stream().mapToDouble(Shippable::getWeight).sum();
        double shippingCost = totalWeight > 0 ? SHIPPING_RATE_PER_KG : 0;
        double finalAmount = orderTotal + shippingCost;

        if (customer.getBalance() < finalAmount) {
            throw new IllegalStateException("Not enough money in your wallet!");
        }

        customer.deductBalance(finalAmount);

        if (!itemsToShip.isEmpty()) {
            new ShippingService().shipItems(itemsToShip);
        }

        printReceipt(cart, orderTotal, shippingCost, finalAmount, customer.getBalance());
    }

    private void printReceipt(Cart cart, double subtotal, double shippingFee, double total, double balanceAfter) {
        System.out.println("=== Your Receipt ===");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " - " + (int)item.getTotalPrice() + " EGP");
        }
        System.out.println("--------------------");
        System.out.println("Subtotal: " + (int)subtotal + " EGP");
        System.out.println("Shipping cost: " + (int)shippingFee + " EGP");
        System.out.println("Total amount: " + (int)total + " EGP");
        System.out.println("Your remaining balance: " + (int)balanceAfter + " EGP");
    }
}