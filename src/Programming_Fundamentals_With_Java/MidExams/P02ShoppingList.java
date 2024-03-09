package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {

            String[] commandSplit = command.split(" ");
            String commandFirst = commandSplit[0];
            String product = commandSplit[1];

            if (commandFirst.equals("Urgent")) {
                if (!products.contains(product)) {
                    products.add(0, product);
                }

            } else if (commandFirst.equals("Unnecessary")) {
                if (products.contains(product)) {
                    products.remove(product);
                }

            } else if (commandFirst.equals("Correct")) {
                String product2 = commandSplit[2];
                if (products.contains(product)) {
                    products.set(products.indexOf(product), product2);
                }

            } else if (commandFirst.equals("Rearrange")) {
                if (products.contains(product)) {
                    products.remove(product);
                    products.add(product);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));
    }
}
