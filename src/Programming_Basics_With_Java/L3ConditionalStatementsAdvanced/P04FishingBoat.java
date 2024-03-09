package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());

        double shipPrice = 0;

        if (season.equals("Spring")) {
            shipPrice = 3000;
        } else if (season.equals("Summer") || season.equals("Autumn")) {
            shipPrice = 4200;
        } else if (season.equals("Winter")) {
            shipPrice = 2600;
        }

        double discountPercentage;

        if (fishers <= 6) {
            discountPercentage = 0.10;
        } else if (fishers <= 11) {
            discountPercentage = 0.15;
        } else {
            discountPercentage = 0.25;
        }

        shipPrice = shipPrice - (shipPrice * discountPercentage);

        if (fishers % 2 == 0 && !season.equals("Autumn")) {
            shipPrice = shipPrice - (shipPrice * 0.05);
        }

        double left = Math.abs(budget - shipPrice);

        if (shipPrice <= budget) {
            System.out.printf("Yes! You have %.2f leva left.", left);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", left);
        }
    }
}
