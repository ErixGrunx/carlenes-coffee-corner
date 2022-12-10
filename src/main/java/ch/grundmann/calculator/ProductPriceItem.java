package ch.grundmann.calculator;

import ch.grundmann.product.ProductType;

public class ProductPriceItem {

    private final ProductType productType;
    private String name;
    private float price;

    public ProductPriceItem(String name, float price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
