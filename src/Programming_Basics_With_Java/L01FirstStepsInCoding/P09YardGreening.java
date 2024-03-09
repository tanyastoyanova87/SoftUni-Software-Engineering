package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double squareMeters = Double.parseDouble(scanner.nextLine());

        double oneSquareMeter = squareMeters * 7.61;
        double discount = 0.18 * oneSquareMeter;
        double finalPrice = oneSquareMeter - discount;

        String finalPriceResult = "The final price is " + finalPrice  + " lv.";
        String discountPriceResult = "The discount is " + discount + " lv.";

        System.out.println(finalPriceResult);
        System.out.println(discountPriceResult);
    }
}
