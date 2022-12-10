package ch.grundmann.calcualtor;

import ch.grundmann.CarlenesCoffeeCornerPriceListMain;
import ch.grundmann.product.CoffeeCornerProduct;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

class DefaultPriceCalculator {

    private static final Logger logger = Logger.getLogger(CarlenesCoffeeCornerPriceListMain.class.getName());

    List<ProductPriceItem> calculate(List<CoffeeCornerProduct> productList) {
        logger.log(INFO, "Calculate product prices.");

        return productList.stream()
                .map(it -> new ProductPriceItem(it.getName(), it.getPrice(), it.getProductType()))
                .toList();
    }
}
