import core.Cart;
import core.Customer;
import models.Product;
import services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product chocolate = new Product("Chocolate", 90, 8, true, LocalDate.now().plusDays(5), true, 0.2);
        Product phone = new Product("Phone", 450, 2, false, null, true, 0.5);
        Product giftCard = new Product("GiftCard", 75, 15, false, null, false, 0);
        Product cookies = new Product("Cookies", 130, 4, true, LocalDate.now().plusDays(3), true, 0.3);

        Customer customer = new Customer("Fatma", 1500);

        Cart cart = new Cart();
        cart.add(chocolate, 3);
        cart.add(cookies, 2);
        cart.add(giftCard, 1);

        CheckoutService checkout = new CheckoutService();
        checkout.checkout(customer, cart);
    }
}