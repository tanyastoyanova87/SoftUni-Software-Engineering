package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String bigOrSmall = scanner.nextLine();
        int purchased = Integer.parseInt(scanner.nextLine());

        double price = 0;
        int gelCount = 0;

        if (fruit.equals("Watermelon")){
            if (bigOrSmall.equals("small")){
                price = 56;
                gelCount = 2;
            } else if (bigOrSmall.equals("big")) {
                price = 28.70;
                gelCount = 5;
            }


        } else if (fruit.equals("Mango")) {
            if (bigOrSmall.equals("small")) {
                price = 36.66;
                gelCount = 2;
            } else if (bigOrSmall.equals("big")) {
                price = 19.60;
                gelCount = 5;
            }

        } else if (fruit.equals("Pineapple")) {
            if (bigOrSmall.equals("small")){
                price = 42.10;
                gelCount = 2;
            } else if (bigOrSmall.equals("big")) {
                price = 24.80;
                gelCount = 5;
            }
            
        } else if (fruit.equals("Raspberry")) {
            if (bigOrSmall.equals("small")){
                price = 20;
                gelCount = 2;
            } else if (bigOrSmall.equals("big")) {
                price = 15.20;
                gelCount = 5;
            }

        }
        double discount = 0;
        double priceGels = gelCount * price;
        double totalPrice = priceGels * purchased;

        if (totalPrice >= 400 && totalPrice <= 1000){
            discount = 0.15 * totalPrice;
        }else if (totalPrice > 1000){
            discount = 0.50 * totalPrice;
        }
        double totalPriceWithDiscount = totalPrice - discount;
        System.out.printf("%.2f lv.%n", totalPriceWithDiscount);
    }
}
