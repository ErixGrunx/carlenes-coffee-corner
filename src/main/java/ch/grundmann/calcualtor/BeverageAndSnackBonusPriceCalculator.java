package ch.grundmann.calcualtor;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

class BeverageAndSnackBonusPriceCalculator {

    private static final Logger logger = Logger.getLogger(BeverageAndSnackBonusPriceCalculator.class.getName());

    void apply(List<ProductPriceItem> productPriceItems) {
        logger.log(INFO, "Apply beverage&snack bonus program to the cheapest product.");

        var minPriceItem = productPriceItems.stream()
                .min(Comparator.comparingDouble(ProductPriceItem::getPrice)).orElseThrow();

        if (minPriceItem.getPrice() == 0f) {
            logger.log(INFO, "The cheapest product is already for free. The bonus can not be applied.");
            return;
        }
        minPriceItem.setPrice(0f);
        minPriceItem.setName(String.format("%s (extra free)", minPriceItem.getName()));
    }
}
