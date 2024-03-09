package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double chairPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double taxTotal = people * tax;
        double chairPriceTotal = (Math.ceil(people * 0.75) * chairPrice);
        double umbrellaTotalPrice = (Math.ceil(people * 1.0 / 2) * umbrellaPrice);

        double totalPrice = taxTotal + chairPriceTotal + umbrellaTotalPrice;

        System.out.printf("%.2f lv.%n", totalPrice);
    }
}
