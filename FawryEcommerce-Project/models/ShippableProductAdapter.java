package models;

public class ShippableProductAdapter implements Shippable {
    private final Product product;

    public ShippableProductAdapter(Product product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getWeight() {
        return product.getWeight();
    }
}