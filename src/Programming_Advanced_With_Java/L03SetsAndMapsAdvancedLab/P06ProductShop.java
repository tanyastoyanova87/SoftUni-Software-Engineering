package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> shopsProducts = new TreeMap<>();
        Map<String, Double> productsPrice = new TreeMap<>();

        String product = scanner.nextLine();
        while (!"Revision".equals(product)) {

            String[] productInfo = product.split(", ");
            String shop = productInfo[0];
            String productType = productInfo[1];
            double price = Double.parseDouble(productInfo[2]);

            shopsProducts.putIfAbsent(shop, new ArrayList<>());
            shopsProducts.get(shop).add(productType);
            productsPrice.putIfAbsent(productType, price);

            product = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> shops : shopsProducts.entrySet()) {
            System.out.printf("%s->%n", shops.getKey());
            for (String shop : shops.getValue()) {
                System.out.printf("P03ShoppingSpree.Product: %s, Price: %.1f%n", shop, productsPrice.get(shop));
            }
        }

    }
}

