package ch.grundmann.printer;

import ch.grundmann.CarlenesCoffeeCornerPriceListMain;
import ch.grundmann.calculator.ProductPriceItem;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class PriceListPrinter {

    private static final Logger logger = Logger.getLogger(CarlenesCoffeeCornerPriceListMain.class.getName());

    public String print(List<ProductPriceItem> productPriceItemList) {
        logger.log(INFO, "Generate printable price list.");

        var printablePriceList = new StringBuilder("\n--PRICE LIST--\n");
        printItemPrices(productPriceItemList, printablePriceList);

        printTotalPrice(productPriceItemList, printablePriceList);

        return printablePriceList.toString();
    }

    private void printItemPrices(List<ProductPriceItem> productPriceItemList, StringBuilder printablePriceList) {
        for (var productPriceItem : productPriceItemList) {
            printablePriceList.append(productPriceItem.getName()).append(": ").append(String.format(Locale.ENGLISH, "%.2f", productPriceItem.getPrice())).append(" CHF\n");
        }
    }

    private void printTotalPrice(List<ProductPriceItem> productPriceItemList, StringBuilder printablePriceList) {
        float totalPrice = 0;
        for (var productPriceItem : productPriceItemList) {
            totalPrice += productPriceItem.getPrice();
        }
        printablePriceList.append("-------------\n");
        printablePriceList.append("Total price: ").append(String.format(Locale.ENGLISH, "%.2f", totalPrice)).append(" CHF\n");
    }
}
