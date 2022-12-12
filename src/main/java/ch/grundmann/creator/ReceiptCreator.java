package ch.grundmann.creator;

import ch.grundmann.calculator.ReceiptCalculator;
import ch.grundmann.calculator.StampCard;
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

    public String create(List<CoffeeCornerProduct> coffeeCornerProductList, StampCard stampCard) {
        var receipt = receiptCalculator.createReceipt(coffeeCornerProductList, stampCard);
        return receiptPrinter.print(receipt);
    }
}
