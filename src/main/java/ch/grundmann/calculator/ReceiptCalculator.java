package ch.grundmann.calculator;

import ch.grundmann.product.CoffeeCornerProduct;

import java.util.List;
import java.util.logging.Logger;

import static ch.grundmann.product.ProductType.BEVERAGE;
import static ch.grundmann.product.ProductType.SNACK;
import static java.util.logging.Level.INFO;

public class ReceiptCalculator {

    private static final Logger logger = Logger.getLogger(ReceiptCalculator.class.getName());

    private final BeverageAndSnackBonusPriceCalculator beverageAndSnackBonusPriceCalculator;
    private final FifthBeverageFreeBonusPriceCalculator fifthBeverageFreeBonusPriceCalculator;

    public ReceiptCalculator() {
        beverageAndSnackBonusPriceCalculator = new BeverageAndSnackBonusPriceCalculator();
        fifthBeverageFreeBonusPriceCalculator = new FifthBeverageFreeBonusPriceCalculator();
    }

    public List<ProductPriceItem> createReceipt(List<CoffeeCornerProduct> productList, StampCard stampCard) {
        if (productList == null) {
            throw new NullPointerException("Product list must not be null.");
        }
        if (productList.isEmpty()) {
            logger.log(INFO, "Shopping basket is empty. Please select products first.");
        }
        logger.log(INFO, "Start to create receipt.");

        var productPriceItemList = productList.stream()
                .map(it -> new ProductPriceItem(it.getName(), it.getPrice(), it.getProductType()))
                .toList();

        var beverages = getBeverages(productPriceItemList);
        var snacks = getSnacks(productPriceItemList);

        fifthBeverageFreeBonusPriceCalculator.apply(beverages, stampCard);
        if (!beverages.isEmpty() && !snacks.isEmpty()) {
            beverageAndSnackBonusPriceCalculator.apply(productPriceItemList);
        }

        return productPriceItemList;
    }

    private List<ProductPriceItem> getBeverages(List<ProductPriceItem> productPriceItemList) {
        return productPriceItemList.stream()
                .filter(it -> BEVERAGE.equals(it.getProductType()))
                .toList();
    }

    private List<ProductPriceItem> getSnacks(List<ProductPriceItem> productPriceItemList) {
        return productPriceItemList.stream()
                .filter(it -> SNACK.equals(it.getProductType()))
                .toList();
    }
}
