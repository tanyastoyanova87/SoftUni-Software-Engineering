package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;

        if (town.equals("Sofia")){
            if (product.equals("coffee")){
                price = 0.50;
            }if (product.equals("water")){
                price = 0.80;
            }if (product.equals("beer")){
                price = 1.20;
            }if (product.equals("sweets")){
                price = 1.45;
            }if (product.equals("peanuts")){
                price = 1.60;
            }
        }

        if (town.equals("Plovdiv")){
            if (product.equals("coffee")){
                price = 0.40;
            }if (product.equals("water")){
                price = 0.70;
            }if (product.equals("beer")){
                price = 1.15;
            }if (product.equals("sweets")){
                price = 1.30;
            }if (product.equals("peanuts")){
                price = 1.50;
            }
        }

        if (town.equals("Varna")){
            if (product.equals("coffee")){
                price = 0.45;
            }if (product.equals("water")){
                price = 0.70;
            }if (product.equals("beer")){
                price = 1.10;
            }if (product.equals("sweets")){
                price = 1.35;
            }if (product.equals("peanuts")){
                price = 1.55;
            }
        }

        System.out.println(quantity * price);
    }
}
