package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> productsPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsQuantity = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("buy")) {
            String[] productInfo = command.split(" ");
            String productName = productInfo[0];
            double price = Double.parseDouble(productInfo[1]);
            int quantity = Integer.parseInt(productInfo[2]);

            productsPrice.put(productName, price);

            if (!productsQuantity.containsKey(productName)) {
                productsQuantity.put(productName, quantity);
            } else {
                productsQuantity.put(productName, productsQuantity.get(productName) + quantity);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> kvp : productsPrice.entrySet()) {
            double totalPrice = kvp.getValue() * productsQuantity.get(kvp.getKey());
            System.out.printf("%s -> %.2f%n", kvp.getKey(), totalPrice);
        }


    }
}
