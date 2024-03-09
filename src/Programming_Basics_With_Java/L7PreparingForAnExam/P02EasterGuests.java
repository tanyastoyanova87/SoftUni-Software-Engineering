package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guestsCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        Double easterBreadNeeded = Math.ceil(guestsCount * 1.0 / 3);
        int eggsNeeded = guestsCount * 2;

        double easterBreadPrice = easterBreadNeeded * 4;
        double eggsPrice = eggsNeeded * 0.45;
        double totalPrice = easterBreadPrice + eggsPrice;

        double left = Math.abs(budget - totalPrice);
        if (budget >= totalPrice){
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.%n", easterBreadNeeded, eggsNeeded);
            System.out.printf("He has %.2f lv. left.%n", left);
        }else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.%n", left);
        }
    }
}
