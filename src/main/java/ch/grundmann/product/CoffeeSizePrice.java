package ch.grundmann.product;

public enum CoffeeSizePrice {

    LARGE("large", 3.5f),
    MEDIUM("medium", 3f),
    SMALL("small", 2.5f);

    private final String title;
    private final float price;

    CoffeeSizePrice(String title, float price) {
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
