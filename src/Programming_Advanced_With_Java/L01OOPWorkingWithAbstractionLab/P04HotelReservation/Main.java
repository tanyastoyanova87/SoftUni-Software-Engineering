package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType discount = DiscountType.valueOf(input[3]);

        double finalPrice = PriceCalculator.calculatorPrice(pricePerDay, numberOfDays, season, discount);
        System.out.printf("%.2f%n", finalPrice);

    }
}
