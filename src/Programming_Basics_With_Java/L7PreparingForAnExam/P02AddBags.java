package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceLuggageOver20Kg = Double.parseDouble(scanner.nextLine());
        double luggageKg = Double.parseDouble(scanner.nextLine());
        int daysTillTrip = Integer.parseInt(scanner.nextLine());
        int countLuggage = Integer.parseInt(scanner.nextLine());

        double luggagePrice = 0;
        if (luggageKg < 10){
            luggagePrice = 0.20 * priceLuggageOver20Kg;
        } else if (luggageKg >= 10 && luggageKg <= 20) {
            luggagePrice = 0.50 * priceLuggageOver20Kg;
        }else if (luggageKg > 20){
            luggagePrice = priceLuggageOver20Kg;
        }

        if (daysTillTrip > 30){
            luggagePrice = luggagePrice + luggagePrice * 0.10;
        } else if (daysTillTrip >= 7) {
            luggagePrice = luggagePrice + luggagePrice * 0.15;
        }else {
            luggagePrice = luggagePrice + luggagePrice * 0.40;
        }
        double totalSum = luggagePrice * countLuggage;
        System.out.printf("The total price of bags is: %.2f lv.%n", totalSum);
    }
}
