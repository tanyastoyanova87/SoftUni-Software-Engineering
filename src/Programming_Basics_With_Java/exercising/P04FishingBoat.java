package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (season.equals("Spring")){
            price = 3000;
            if (fishers % 2 == 0){
                price = price - (price * 0.05);
            }
        } else if (season.equals("Summer")) {
            price = 4200;
            if (fishers % 2 == 0){
                price = price - (price * 0.05);
            }
        } else if (season.equals("Autumn")) {
            price = 4200;

        } else if (season.equals("Winter")) {
            price = 2600;
            if (fishers % 2 == 0){
                price = price - (price * 0.05);
            }
        }
        if (fishers <= 6){
            price = price - (price * 0.10);
        } else if (fishers > 6 && fishers <= 11) {
            price = price - (price * 0.15);
        }else if (fishers >= 12){
            price = price - (price * 0.25);
        }
        double leftOrNeed = Math.abs(budget - price);
        if (budget >= price){
            System.out.printf("Yes! You have %.2f leva left.%n", leftOrNeed);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.%n", leftOrNeed);
        }
    }
}
