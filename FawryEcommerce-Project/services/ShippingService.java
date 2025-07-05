package services;

import models.Shippable;
import java.util.List;

public class ShippingService {

    public void shipItems(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("--- Your order is being shipped! ---");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.println("Item: " + item.getName());
            System.out.println("Weight: " + (int)(item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight();
        }

        System.out.println("Total weight of your package: " + totalWeight + "kg");
    }
}