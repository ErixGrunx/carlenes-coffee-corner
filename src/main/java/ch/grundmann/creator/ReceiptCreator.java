package ch.grundmann.creator;

import ch.grundmann.calculator.ReceiptCalculator;
import ch.grundmann.printer.PriceListPrinter;
import ch.grundmann.product.CoffeeCornerProduct;

import java.util.List;

public class ReceiptCreator {
    private final ReceiptCalculator receiptCalculator;
    private final PriceListPrinter receiptPrinter;

    public ReceiptCreator() {
        this.receiptCalculator = new ReceiptCalculator();
        this.receiptPrinter = new PriceListPrinter();
    }

    public String create(List<CoffeeCornerProduct> coffeeCornerProductList) {
        var receipt = receiptCalculator.createReceipt(coffeeCornerProductList);
        return receiptPrinter.print(receipt);
    }

    public String createWithFreeBeverage(List<CoffeeCornerProduct> coffeeCornerProductList) {
        var receipt = receiptCalculator.createReceiptWithFreeBeverage(coffeeCornerProductList);
        return receiptPrinter.print(receipt);
    }
}
