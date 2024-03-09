package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double videoCardsPrice = videoCards * 250;
        double processorPrice = (0.35 * videoCardsPrice) * processors;
        double ramPrice = (0.10 * videoCardsPrice) * ram;
        double totalPrice = videoCardsPrice + processorPrice + ramPrice;

        if (videoCards > processors){
            totalPrice = totalPrice - (totalPrice * 0.15);
        }
        double leftOrNeeded = Math.abs(budget - totalPrice);
        if (budget >= totalPrice){
            System.out.printf("You have %.2f leva left!%n", leftOrNeeded);
        }else {
            System.out.printf("Not enough money! You need %.2f leva more!%n", leftOrNeeded);
        }
    }
}
