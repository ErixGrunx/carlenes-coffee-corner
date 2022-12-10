package ch.grundmann.product;

public enum CoffeeExtraPrice {

    EXTRA_MILK("extra milk", 0.3f),
    FOAMED_MILK("foamed milk", 0.5f),
    SPECIAL_ROAST_COFFEE("special roast coffee", 0.9f),
    NONE("", 0.0f);

    private final String title;
    private final float price;

    CoffeeExtraPrice(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }
}
