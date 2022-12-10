package ch.grundmann.creator;

import ch.grundmann.calculator.PriceListCalculator;
import ch.grundmann.printer.PriceListPrinter;
import ch.grundmann.product.CoffeeCornerProduct;

import java.util.List;

public class PriceListCreator {
    private final PriceListCalculator priceListCalculator;
    private final PriceListPrinter priceListPrinter;

    public PriceListCreator() {
        this.priceListCalculator = new PriceListCalculator();
        this.priceListPrinter = new PriceListPrinter();
    }

    public String create(List<CoffeeCornerProduct> coffeeCornerProductList) {
        var priceList = priceListCalculator.createPriceList(coffeeCornerProductList);
        return priceListPrinter.print(priceList);
    }

    public String createWithFreeBeverage(List<CoffeeCornerProduct> coffeeCornerProductList) {
        var priceList = priceListCalculator.createPriceListWithFreeBeverage(coffeeCornerProductList);
        return priceListPrinter.print(priceList);
    }
}
