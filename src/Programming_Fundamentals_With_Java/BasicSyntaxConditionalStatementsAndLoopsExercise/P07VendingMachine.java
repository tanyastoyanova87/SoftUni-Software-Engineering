package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double sumCoins = 0;
        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);

            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f%n", coins);
            } else {
                sumCoins += coins;
            }
                command = scanner.nextLine();
        }
        String products = scanner.nextLine();

        double price = 0;
        while (!products.equals("End")){

            if (products.equals("Nuts")){
                price = 2;
                if (sumCoins >= 2){
                    System.out.printf("Purchased %s%n", products);
                    sumCoins -= price;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Water")) {
                price = 0.7;
                if (sumCoins >= 0.7){
                    System.out.printf("Purchased %s%n", products);
                    sumCoins -= price;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Crisps")) {
                price = 1.5;
                if (sumCoins >= 1.5){
                    System.out.printf("Purchased %s%n", products);
                    sumCoins -= price;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Soda")) {
                price = 0.8;
                if (sumCoins >= 0.8){
                    System.out.printf("Purchased %s%n", products);
                    sumCoins -= price;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Coke")) {
                price = 1;
                if (sumCoins >= 1){
                    System.out.printf("Purchased %s%n", products);
                    sumCoins -= price;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            }else {
                System.out.println("Invalid product");
            }

            products = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", sumCoins);
    }
}
