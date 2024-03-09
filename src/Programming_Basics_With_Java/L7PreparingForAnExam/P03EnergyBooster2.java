package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03EnergyBooster2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int setCount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (fruit.equals("Watermelon")){
            if (size.equals("small")){
                price = 56 * 2;

            } else if (size.equals("big")) {
                price = 28.70 * 5;
            }


        } else if (fruit.equals("Mango")) {
            if (size.equals("small")){
                price = 36.66 * 2;
            } else if (size.equals("big")) {
                price = 19.60 * 5;
            }


        } else if (fruit.equals("Pineapple")) {
            if (size.equals("small")){
                price = 42.10 * 2;
            } else if (size.equals("big")) {
                price = 24.80 * 5;
            }
            
            
        } else if (fruit.equals("Raspberry")) {
            if (size.equals("small")){
                price = 20 * 2;
            } else if (size.equals("big")) {
                price = 15.20 * 5;
            }
        }
        double totalPrice = price * setCount;

        if (totalPrice >= 400 && totalPrice <= 1000){
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (totalPrice > 1000) {
            totalPrice = totalPrice - (totalPrice * 0.50);
        }

        System.out.printf("%.2f lv.%n", totalPrice);
    }
}
