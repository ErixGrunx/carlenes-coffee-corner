package ch.grundmann;

import ch.grundmann.creator.PriceListCreator;
import ch.grundmann.product.*;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class CarlenesCoffeeCornerPriceListMain {

    private static final Logger logger = Logger.getLogger(CarlenesCoffeeCornerPriceListMain.class.getName());

    public static void main(String[] args) {
        logger.log(INFO, "Generate printable price list.");

        // Create your own shopping list here:
        List<CoffeeCornerProduct> productList = List.of(
                new Coffee(),
                new Coffee(CoffeeSizePrice.SMALL, CoffeeExtraPrice.SPECIAL_ROAST_COFFEE),
                new OrangeJuice(),
                new BaconRoll()
        );

        var priceList = new PriceListCreator().create(productList);
        // call this method instead to use the free beverage bonus:
        // var priceList = new PriceListCreator().createWithFreeBeverage(productList);

        logger.log(INFO, priceList);
    }
}
