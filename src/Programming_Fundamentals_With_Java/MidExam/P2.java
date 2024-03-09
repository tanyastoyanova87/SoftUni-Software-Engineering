package Programming_Fundamentals_With_Java.MidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffees = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= commands; i++) {
            String command = scanner.nextLine();

            String[] commandSplit = command.split(" ");
            String action = commandSplit[0];

            if (action.equals("Include")) {
                String coffee = commandSplit[1];
                coffees.add(coffee);

            } else if (action.equals("Remove")) {
                String firstOrLast = commandSplit[1];
                int numberOfCoffees = Integer.parseInt(commandSplit[2]);

                if (numberOfCoffees <= coffees.size()) {
                    if (firstOrLast.equals("first")) {
                        for (int j = 1; j <= numberOfCoffees; j++) {
                            coffees.remove(0);
                        }
                    } else if (firstOrLast.equals("last")) {
                        for (int j = 1; j <= numberOfCoffees ; j++) {
                            coffees.remove(coffees.size() - 1);
                        }
                    }
                }
            } else if (action.equals("Prefer")) {
                int coffeeIndex1 = Integer.parseInt(commandSplit[1]);
                int coffeeIndex2 = Integer.parseInt(commandSplit[2]);

                if (coffeeIndex1 >= 0 && coffeeIndex1 < coffees.size() && coffeeIndex2 >= 0 && coffeeIndex2 < coffees.size()) {
                    String coffee1 = coffees.get(coffeeIndex1);
                    String coffee2 = coffees.get(coffeeIndex2);
                    coffees.set(coffeeIndex1, coffee2);
                    coffees.set(coffeeIndex2, coffee1);
                }

            } else if (action.equals("Reverse")) {
                Collections.reverse(coffees);
            }
        }

        System.out.println("Coffees:");
        for (String coffee: coffees) {
            System.out.print(coffee + " ");
        }
    }
}