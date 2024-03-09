package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guestsCount = Integer.parseInt(scanner.nextLine());
        double pricePerPerson = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        if (guestsCount >= 10 && guestsCount <= 15){
            pricePerPerson = pricePerPerson - pricePerPerson * 0.15;
        } else if (guestsCount > 15 && guestsCount <= 20) {
            pricePerPerson = pricePerPerson - pricePerPerson * 0.20;
        }else if (guestsCount > 20){
            pricePerPerson = pricePerPerson - pricePerPerson * 0.25;
        }
        double cakePrice = 0.10 * budget;
        double totalPrice = guestsCount * pricePerPerson + cakePrice;

        double left = Math.abs(totalPrice - budget);
        if (totalPrice <= budget){
            System.out.printf("It is party time! %.2f leva left.%n", left);
        }else {
            System.out.printf("No party! %.2f leva needed.%n", left);
        }
    }
}
