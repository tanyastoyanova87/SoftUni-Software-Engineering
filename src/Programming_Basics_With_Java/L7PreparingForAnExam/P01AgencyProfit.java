package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int ticketsAdults = Integer.parseInt(scanner.nextLine());
        int ticketsKids = Integer.parseInt(scanner.nextLine());
        double priceAdults = Double.parseDouble(scanner.nextLine());
        double servingPrice = Double.parseDouble(scanner.nextLine());

        double priceKids = priceAdults - priceAdults * 0.70;
        double priceAdultsWithServing = priceAdults + servingPrice;
        double priceKidsWithServing = priceKids + servingPrice;
        double totalPrice = ticketsKids * priceKidsWithServing + ticketsAdults * priceAdultsWithServing;
        double total = 0.20 * totalPrice;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.%n", name, total);

    }
}
