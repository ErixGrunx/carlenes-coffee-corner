package ch.grundmann.calcualtor;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

class FifthBeverageFreeBonusPriceCalculator {

    private static final Logger logger = Logger.getLogger(FifthBeverageFreeBonusPriceCalculator.class.getName());
    private static final int FIFTH_ELEMENT = 5;

    void apply(List<ProductPriceItem> beverages, boolean isFirstFree) {
        logger.log(INFO, "Apply bonus program to every non free fifth beverage.");

        if (isFirstFree) {
            var productPriceItem = beverages.get(0);
            productPriceItem.setPrice(0.f);
            productPriceItem.setName(productPriceItem.getName() + "(fifth beverage is free)");
        }

        for (var i = 1; i < beverages.size(); i++) {
            if (i % FIFTH_ELEMENT == 0) {
                var fifthBeverage = beverages.get(i - 1);
                fifthBeverage.setPrice(0f);
                fifthBeverage.setName(String.format("%s (fifth beverage is free)", fifthBeverage.getName()));
            }
        }
    }
}
