package ch.grundmann.product;

import static ch.grundmann.product.CoffeeExtraPrice.NONE;
import static ch.grundmann.product.CoffeeSizePrice.MEDIUM;
import static ch.grundmann.product.ProductType.BEVERAGE;

public class Coffee implements CoffeeCornerProduct {
    private final CoffeeSizePrice coffeeSizePrice;
    private final CoffeeExtraPrice coffeeExtraPrice;

    public Coffee() {
        this(MEDIUM, NONE);
    }

    public Coffee(CoffeeSizePrice coffeeSizePrice, CoffeeExtraPrice coffeeExtraPrice) {
        this.coffeeSizePrice = coffeeSizePrice == null ? MEDIUM : coffeeSizePrice;
        this.coffeeExtraPrice = coffeeExtraPrice == null ? NONE : coffeeExtraPrice;
    }

    @Override
    public String getName() {
        if (NONE.equals(coffeeExtraPrice)) {
            return String.format("Coffee %s", coffeeSizePrice.getTitle());
        }

        return String.format("Coffee %s (%s)", coffeeSizePrice.getTitle(), coffeeExtraPrice.getTitle());
    }

    @Override
    public float getPrice() {
        return coffeeSizePrice.getPrice() + coffeeExtraPrice.getPrice();
    }

    @Override
    public ProductType getProductType() {
        return BEVERAGE;
    }
}
