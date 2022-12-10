package ch.grundmann.product;

import static ch.grundmann.product.ProductType.SNACK;

public class BaconRoll implements CoffeeCornerProduct {
    @Override
    public String getName() {
        return "Bacon roll";
    }

    @Override
    public float getPrice() {
        return 3.95f;
    }

    @Override
    public ProductType getProductType() {
        return SNACK;
    }
}
