package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02AddBags2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double luggagePriceOver20Kg = Double.parseDouble(scanner.nextLine());
        double luggageKgs = Double.parseDouble(scanner.nextLine());
        int daysTillTrip = Integer.parseInt(scanner.nextLine());
        int luggageCount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (luggageKgs < 10){
            price = 0.20 * luggagePriceOver20Kg;
        } else if (luggageKgs >= 10 && luggageKgs <= 20) {
            price = 0.50 * luggagePriceOver20Kg;
        }else {
            price = luggagePriceOver20Kg;
        }

        if (daysTillTrip > 30){
            price = price + price * 0.10;
        } else if (daysTillTrip >= 7 && daysTillTrip <= 30) {
            price = price + price * 0.15;
        } else if (daysTillTrip < 7) {
            price = price + price * 0.40;
        }
        double totalPrice = luggageCount * price;

        System.out.printf("The total price of bags is: %.2f lv.%n", totalPrice);
    }
}
