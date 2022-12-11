package ch.grundmann;

import ch.grundmann.creator.ReceiptCreator;
import ch.grundmann.product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharlenesCoffeeCornerReceiptMain {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Welcome to Charlene's coffee corner");
        List<CoffeeCornerProduct> productList = new ArrayList<>();
        var stopOrder = false;
        while (!stopOrder) {
            System.out.println("Press 1 for coffee, 2 for orange juice or 3 for bacon roll: ");
            var product = in.nextLine();
            if ("1".equals(product)) {
                System.out.println("Press 1 for large, 2 for middle or 3 for small: ");
                var coffeeSize = mapToCoffeeSizePrice(in.nextLine());
                System.out.println("Press 1 for extra milk, 2 for foamed milk, 3 for special roast coffee or 4 for no extras: ");
                var coffeeExtra = mapToCoffeeExtraPrice(in.nextLine());
                productList.add(new Coffee(coffeeSize, coffeeExtra));
            } else if ("2".equals(product)) {
                productList.add(new OrangeJuice());
            } else if ("3".equals(product)) {
                productList.add(new BaconRoll());
            }
            System.out.println("Press y to continue, press any key to finish order: ");
            stopOrder = !"y".equals(in.nextLine());
        }

        var receipt = new ReceiptCreator().create(productList);
        System.out.println(receipt);
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
        } return coffeeSize;
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
}
