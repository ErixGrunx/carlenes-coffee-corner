package ch.grundmann;

import ch.grundmann.calculator.StampCard;
import ch.grundmann.product.*;

import java.util.*;

public class CharlenesCoffeeCornerReceiptMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, StampCard> stampCards = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Charlene's coffee corner");

        while (true) {
            var stampCard = getStampCard();
            var productList = getProductListUserInput();

            var receipt = new ReceiptCreator().create(productList, stampCard);
            System.out.println(receipt);

            continueOrExitProgram();
        }
    }

    private static StampCard getStampCard() {
        System.out.println("Enter the Id of the stamp card: ");
        var stampCardId = scanner.nextLine();
        var stampCard = stampCards.get(stampCardId);
        if (stampCard == null) {
            stampCard = new StampCard(stampCardId);
            stampCards.put(stampCardId, stampCard);

        }
        System.out.printf("Stamp count (id: %s): %s\n", stampCard.getId(), stampCard.getCount());
        return stampCard;
    }

    private static List<CoffeeCornerProduct> getProductListUserInput() {
        List<CoffeeCornerProduct> productList = new ArrayList<>();
        var stopOrder = false;
        while (!stopOrder) {
            System.out.println("Press '1' for coffee, '2' for orange juice or '3' for bacon roll: ");
            var product = scanner.nextLine();
            if ("1".equals(product)) {
                System.out.println("Press '1' for large, '2' for middle or '3' for small: ");
                var coffeeSize = mapToCoffeeSizePrice(scanner.nextLine());
                System.out.println("Press '1' for extra milk, '2' for foamed milk, '3' for special roast coffee or '4' for no extras: ");
                var coffeeExtra = mapToCoffeeExtraPrice(scanner.nextLine());
                productList.add(new Coffee(coffeeSize, coffeeExtra));
            } else if ("2".equals(product)) {
                productList.add(new OrangeJuice());
            } else if ("3".equals(product)) {
                productList.add(new BaconRoll());
            }
            System.out.println("Press 'y' to continue, press any key to finish order: ");
            stopOrder = !"y".equals(scanner.nextLine());
        }
        return productList;
    }

    private static CoffeeSizePrice mapToCoffeeSizePrice(String coffeeSizeEntry) {
        CoffeeSizePrice coffeeSize;
        if ("1".equals(coffeeSizeEntry)) {
            coffeeSize = CoffeeSizePrice.LARGE;
        } else if ("2".equals(coffeeSizeEntry)) {
            coffeeSize = CoffeeSizePrice.LARGE;
        } else if ("3".equals(coffeeSizeEntry)) {
            coffeeSize = CoffeeSizePrice.LARGE;
        } else {
            coffeeSize = CoffeeSizePrice.MEDIUM;
        }
        return coffeeSize;
    }

    private static CoffeeExtraPrice mapToCoffeeExtraPrice(String coffeeExtraEntry) {
        CoffeeExtraPrice coffeeExtra;
        if ("1".equals(coffeeExtraEntry)) {
            coffeeExtra = CoffeeExtraPrice.EXTRA_MILK;
        } else if ("2".equals(coffeeExtraEntry)) {
            coffeeExtra = CoffeeExtraPrice.FOAMED_MILK;
        } else if ("3".equals(coffeeExtraEntry)) {
            coffeeExtra = CoffeeExtraPrice.SPECIAL_ROAST_COFFEE;
        } else {
            coffeeExtra = CoffeeExtraPrice.NONE;
        }
        return coffeeExtra;
    }

    private static void continueOrExitProgram() {
        System.out.println("Press 'q' to finish the program, press any key to continue: ");
        var continueShopping = scanner.nextLine();
        if ("q".equals(continueShopping)) {
            System.exit(0);
        }
    }
}
