package ch.grundmann.creator;


import ch.grundmann.calculator.StampCard;
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

class ReceiptCreatorTest {

    private ReceiptCreator receiptCreator;

    @BeforeEach
    void setUp() {
        receiptCreator = new ReceiptCreator();
    }

    @Test
    public void testOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var receipt = receiptCreator.create(productList, new StampCard("a"));

        assertTrue(receipt.contains("3.95 CHF"), "Actual print:" + receipt);
    }

    @Test
    public void testFreeOrangeJuice() {
        List<CoffeeCornerProduct> productList = List.of(new OrangeJuice());
        var receipt = receiptCreator.create(productList, new StampCard("a", 4));

        assertTrue(receipt.contains("Orange juice (fifth beverage is free): 0.00 CHF"), "Actual print:" + receipt);
    }

    @Test
    public void testCoffee1() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee());
        var receipt = receiptCreator.create(productList, new StampCard("a"));

        assertTrue(receipt.contains("3.00 CHF"), "Actual print:" + receipt);
    }

    @Test
    public void testCoffee2() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(MEDIUM, EXTRA_MILK));
        var receipt = receiptCreator.create(productList, new StampCard("a"));

        assertTrue(receipt.contains("3.30 CHF"), "Actual print:" + receipt);
    }

    @Test
    public void testFreeCoffee() {
        List<CoffeeCornerProduct> productList = List.of(new Coffee(MEDIUM, EXTRA_MILK));
        var receipt = receiptCreator.create(productList, new StampCard("a"));

        assertTrue(receipt.contains("Coffee medium (extra milk): 3.30 CHF"), "Actual print:" + receipt);
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
        var receipt = receiptCreator.create(productList, new StampCard("a"));

        assertTrue(receipt.contains("Coffee medium: 3.00 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Coffee large (special roast coffee): 4.40 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Coffee medium (extra milk): 3.30 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Coffee small (foamed milk): 3.00 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Orange juice: 3.95 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Orange juice (fifth beverage is free): 0.00 CHF"), "Actual print:" + receipt);
        assertTrue(receipt.contains("Bacon roll: 3.95 CHF"), "Actual print:" + receipt);
    }

    @Test
    public void testEmptyList() {
        assertDoesNotThrow(() -> receiptCreator.create(List.of(), new StampCard("a")));
    }

    @Test
    public void testNullList() {
        assertThrows(NullPointerException.class, () -> receiptCreator.create(null, new StampCard("a")));
    }

    @Test
    public void testStampCardTwoStamps() {
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK)
        );
        StampCard a = new StampCard("a");
        receiptCreator.create(productList, a);

        assertEquals("a", a.getId());
        assertEquals(2, a.getCount());
    }

    @Test
    public void testStampCardFifeStamps() {
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK)
        );
        StampCard a = new StampCard("a");
        receiptCreator.create(productList, a);

        assertEquals("a", a.getId());
        assertEquals(0, a.getCount());
    }


    @Test
    public void testStampCardElevenStamps() {
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK), new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK), new Coffee(MEDIUM, EXTRA_MILK),
                new Coffee(MEDIUM, EXTRA_MILK)
        );
        StampCard a = new StampCard("a");
        receiptCreator.create(productList, a);

        assertEquals("a", a.getId());
        assertEquals(1, a.getCount());
    }
}
