package ch.grundmann.calculator;

import ch.grundmann.product.BaconRoll;
import ch.grundmann.product.Coffee;
import ch.grundmann.product.CoffeeCornerProduct;
import ch.grundmann.product.OrangeJuice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptCalculatorTest {

    private ReceiptCalculator receiptCalculator;

    @BeforeEach
    void setUp() {
        receiptCalculator = new ReceiptCalculator();
    }

    @Test
    void createReceiptWithOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var receipt = receiptCalculator.createReceipt(productList);

        assertEquals(1, receipt.size());
        assertEquals("Orange juice", receipt.get(0).getName());
    }

    @Test
    void createReceiptWithFreeBeverageOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var receipt = receiptCalculator.createReceiptWithFreeBeverage(productList);

        assertEquals(1, receipt.size());
        assertEquals("Orange juice(fifth beverage is free)", receipt.get(0).getName());
    }

    @Test
    void createReceiptWithCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var receipt = receiptCalculator.createReceipt(productList);

        assertEquals(1, receipt.size());
        assertEquals("Coffee medium", receipt.get(0).getName());
    }

    @Test
    void createReceiptWithFreeBeverageCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var receipt = receiptCalculator.createReceiptWithFreeBeverage(productList);

        assertEquals(1, receipt.size());
        assertEquals("Coffee medium(fifth beverage is free)", receipt.get(0).getName());
    }

    @Test
    void createReceiptWithCoffeeAndOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new OrangeJuice());
        var receipt = receiptCalculator.createReceipt(productList);

        assertEquals(2, receipt.size());
        assertEquals("Coffee medium", receipt.get(0).getName());
        assertEquals("Orange juice", receipt.get(1).getName());
    }

    @Test
    void createReceiptWithFreeBeverageCoffeeAndOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new OrangeJuice());
        var receipt = receiptCalculator.createReceiptWithFreeBeverage(productList);

        assertEquals(2, receipt.size());
        assertEquals("Coffee medium(fifth beverage is free)", receipt.get(0).getName());
        assertEquals("Orange juice", receipt.get(1).getName());
    }

    @Test
    void createReceiptWithCoffeeAndBaconRoll() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new BaconRoll());
        var receipt = receiptCalculator.createReceipt(productList);

        assertEquals(2, receipt.size());
        assertEquals("Coffee medium (extra free)", receipt.get(0).getName());
        assertEquals("Bacon roll", receipt.get(1).getName());
    }

    @Test
    void createReceiptWithFreeBeverageCoffeeAndBaconRoll() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(), new BaconRoll());
        var receipt = receiptCalculator.createReceiptWithFreeBeverage(productList);

        assertEquals(2, receipt.size());
        assertEquals("Coffee medium(fifth beverage is free)", receipt.get(0).getName());
        assertEquals("Bacon roll", receipt.get(1).getName());
    }

    @Test
    void createReceiptWithFiveCoffee() {
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee(),
                new Coffee());
        var receipt = receiptCalculator.createReceipt(productList);

        assertEquals(6, receipt.size());
        assertEquals("Coffee medium", receipt.get(0).getName());
        assertEquals("Coffee medium", receipt.get(1).getName());
        assertEquals("Coffee medium", receipt.get(2).getName());
        assertEquals("Coffee medium", receipt.get(3).getName());
        assertEquals("Coffee medium (fifth beverage is free)", receipt.get(4).getName());
        assertEquals("Coffee medium", receipt.get(5).getName());
    }
}
