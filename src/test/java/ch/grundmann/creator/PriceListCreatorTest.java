package ch.grundmann.creator;


import ch.grundmann.product.BaconRoll;
import ch.grundmann.product.Coffee;
import ch.grundmann.product.CoffeeCornerProduct;
import ch.grundmann.product.OrangeJuice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch.grundmann.product.CoffeeExtraPrice.*;
import static ch.grundmann.product.CoffeeSizePrice.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceListCreatorTest {

    private PriceListCreator priceListCreator;

    @BeforeEach
    void setUp() {
        priceListCreator = new PriceListCreator();
    }

    @Test
    public void testOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var priceList = priceListCreator.create(productList);

        assertTrue(priceList.contains("3.95 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testFreeOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var priceList = priceListCreator.createWithFreeBeverage(productList);

        assertTrue(priceList.contains("Orange juice(fifth beverage is free): 0.00 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testCoffee1() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var priceList = priceListCreator.create(productList);

        assertTrue(priceList.contains("3.00 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testCoffee2() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(MEDIUM, EXTRA_MILK));
        var priceList = priceListCreator.create(productList);

        assertTrue(priceList.contains("3.30 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testFreeCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(MEDIUM, EXTRA_MILK));
        var priceList = priceListCreator.create(productList);

        assertTrue(priceList.contains("Coffee medium (extra milk): 3.30 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testLargePriceList() {

        var productList = List.of(
                new Coffee(),
                new Coffee(LARGE, SPECIAL_ROAST_COFFEE),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(SMALL, FOAMED_MILK),
                new OrangeJuice(),
                new OrangeJuice(),
                new BaconRoll()
        );
        var priceList = priceListCreator.create(productList);

        assertTrue(priceList.contains("Coffee medium: 3.00 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Coffee large (special roast coffee): 4.40 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Coffee medium (extra milk): 3.30 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Coffee small (foamed milk): 3.00 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Orange juice: 3.95 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Orange juice (fifth beverage is free): 0.00 CHF"), "Actual print:" + priceList);
        assertTrue(priceList.contains("Bacon roll: 3.95 CHF"), "Actual print:" + priceList);
    }

    @Test
    public void testEmptyList() {
        assertDoesNotThrow(() -> priceListCreator.create(List.of()));
    }

    @Test
    public void testNullList() {
        assertThrows(NullPointerException.class, () -> priceListCreator.create(null));
    }
}
