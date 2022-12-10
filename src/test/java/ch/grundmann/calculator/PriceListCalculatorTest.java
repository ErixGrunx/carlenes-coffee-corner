package ch.grundmann.calculator;

import ch.grundmann.product.BaconRoll;
import ch.grundmann.product.Coffee;
import ch.grundmann.product.CoffeeCornerProduct;
import ch.grundmann.product.OrangeJuice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceListCalculatorTest {

    private PriceListCalculator priceListCalculator;

    @BeforeEach
    void setUp() {
        priceListCalculator = new PriceListCalculator();
    }

    @Test
    void createPriceListWithOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var priceList = priceListCalculator.createPriceList(productList);

        assertEquals(1, priceList.size());
        assertEquals("Orange juice", priceList.get(0).getName());
    }

    @Test
    void createPriceListWithFreeBeverageOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var priceList = priceListCalculator.createPriceListWithFreeBeverage(productList);

        assertEquals(1, priceList.size());
        assertEquals("Orange juice(fifth beverage is free)", priceList.get(0).getName());
    }

    @Test
    void createPriceListWithCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var priceList = priceListCalculator.createPriceList(productList);

        assertEquals(1, priceList.size());
        assertEquals("Coffee medium", priceList.get(0).getName());
    }

    @Test
    void createPriceListWithFreeBeverageCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var priceList = priceListCalculator.createPriceListWithFreeBeverage(productList);

        assertEquals(1, priceList.size());
        assertEquals("Coffee medium(fifth beverage is free)", priceList.get(0).getName());
    }

    @Test
    void createPriceListWithCoffeeAndOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new OrangeJuice());
        var priceList = priceListCalculator.createPriceList(productList);

        assertEquals(2, priceList.size());
        assertEquals("Coffee medium", priceList.get(0).getName());
        assertEquals("Orange juice", priceList.get(1).getName());
    }

    @Test
    void createPriceListWithFreeBeverageCoffeeAndOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new OrangeJuice());
        var priceList = priceListCalculator.createPriceListWithFreeBeverage(productList);

        assertEquals(2, priceList.size());
        assertEquals("Coffee medium(fifth beverage is free)", priceList.get(0).getName());
        assertEquals("Orange juice", priceList.get(1).getName());
    }

    @Test
    void createPriceListWithCoffeeAndBaconRoll() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new BaconRoll());
        var priceList = priceListCalculator.createPriceList(productList);

        assertEquals(2, priceList.size());
        assertEquals("Coffee medium (extra free)", priceList.get(0).getName());
        assertEquals("Bacon roll", priceList.get(1).getName());
    }

    @Test
    void createPriceListWithFreeBeverageCoffeeAndBaconRoll() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new BaconRoll());
        var priceList = priceListCalculator.createPriceListWithFreeBeverage(productList);

        assertEquals(2, priceList.size());
        assertEquals("Coffee medium(fifth beverage is free)", priceList.get(0).getName());
        assertEquals("Bacon roll", priceList.get(1).getName());
    }

    @Test
    void createPriceListWithFiveCoffee() {
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee());
        var priceList = priceListCalculator.createPriceList(productList);

        assertEquals(6, priceList.size());
        assertEquals("Coffee medium", priceList.get(0).getName());
        assertEquals("Coffee medium", priceList.get(1).getName());
        assertEquals("Coffee medium", priceList.get(2).getName());
        assertEquals("Coffee medium", priceList.get(3).getName());
        assertEquals("Coffee medium (fifth beverage is free)", priceList.get(4).getName());
        assertEquals("Coffee medium", priceList.get(5).getName());
    }
}
