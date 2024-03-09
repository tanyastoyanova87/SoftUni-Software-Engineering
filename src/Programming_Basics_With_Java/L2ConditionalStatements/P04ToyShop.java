package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int allToys = puzzles + dolls + teddyBears + minions + trucks;
        double toysPrice = puzzles * 2.60 + dolls * 3 + teddyBears * 4.10 + minions * 8.20 + trucks * 2;

        if (allToys >= 50){
            toysPrice = toysPrice - toysPrice * 0.25;
        }
         toysPrice = toysPrice - toysPrice * 0.1;

        if (tripPrice <= toysPrice){
            double left = toysPrice - tripPrice;
            System.out.printf("Yes! %.2f lv left.", left);
        } else {
            double needed = tripPrice - toysPrice;
            System.out.printf("Not enough money! %.2f lv needed.", needed);
        }
    }
}
