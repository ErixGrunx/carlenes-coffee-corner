package ch.grundmann.product;

import static ch.grundmann.product.ProductType.BEVERAGE;

public class OrangeJuice implements CoffeeCornerProduct {

    public OrangeJuice() {
    }

    @Override
    public String getName() {
        return "Orange juice";
    }

    @Override
    public float getPrice() {
        return 3.95f;
    }

    @Override
    public ProductType getProductType() {
        return BEVERAGE;
    }
}
