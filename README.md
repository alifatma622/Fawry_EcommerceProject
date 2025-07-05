# FawryEcommerce-Project

A simple Java-based e-commerce simulation with cart, checkout, and shipping logic.

## Project Structure

```
FawryEcommerce-Project/
  Main.java
  core/
    Cart.java
    CartItem.java
    Customer.java
  models/
    Product.java
    Shippable.java
    ShippableProductAdapter.java
  services/
    CheckoutService.java
    ShippingService.java
```

## Features

- Add products to a shopping cart
- Check product expiry and stock
- Calculate order total and shipping cost
- Deduct customer balance on checkout
- Print a receipt and shipping details

## How to Run

1. **Compile all Java files:**
   ```sh
   javac Main.java core/*.java models/*.java services/*.java
   ```

2. **Run the main class:**
   ```sh
   java Main
   ```

## Example Output

```
=== Your Receipt ===
1x Chocolate - 90 EGP
2x Cookies - 260 EGP
1x GiftCard - 75 EGP
--------------------
Subtotal: 425 EGP
Shipping cost: 30 EGP
Total amount: 455 EGP
Your remaining balance: 1045 EGP
--- Your order is being shipped! ---
Item: Chocolate
Weight: 200g
Item: Cookies
Weight: 300g
Item: Cookies
Weight: 300g
Total weight of your package: 0.8kg
```

## Author

-Fatma Elshihna
