package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegetarian = Integer.parseInt(scanner.nextLine());

        double chickenPrice = chicken * 10.35;
        double fishPrice = fish * 12.40;
        double vegPrice = vegetarian * 8.15;

        double fullPrice = chickenPrice + fishPrice + vegPrice;

        double dessert = fullPrice * 0.20;

        double finalPrice = fullPrice + dessert + 2.50;

        System.out.println(finalPrice);

    }
}
