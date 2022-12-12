package ch.grundmann.calculator;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

class FifthBeverageFreeBonusPriceCalculator {

    private static final Logger logger = Logger.getLogger(FifthBeverageFreeBonusPriceCalculator.class.getName());
    private static final int FIFTH_ELEMENT = 5;

    void apply(List<ProductPriceItem> beverages, StampCard stampCard) {
        logger.log(INFO, "Apply bonus program to every non free fifth beverage.");

        for (var i = 1; i <= beverages.size(); i++) {
            stampCard.setCount(stampCard.getCount() + 1);
            if (stampCard.getCount() % FIFTH_ELEMENT == 0) {
                var fifthBeverage = beverages.get(i - 1);
                fifthBeverage.setPrice(0f);
                fifthBeverage.setName(String.format("%s (fifth beverage is free)", fifthBeverage.getName()));
                var newCount = stampCard.getCount() - FIFTH_ELEMENT;
                if (newCount >= 0) {
                    stampCard.setCount(newCount);
                }
            }
        }
    }
}
