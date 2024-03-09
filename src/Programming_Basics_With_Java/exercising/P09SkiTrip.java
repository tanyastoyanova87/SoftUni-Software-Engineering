package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String place = scanner.nextLine();
        String rating = scanner.nextLine();

        double price = 0;
        if (place.equals("room for one person")){
            price = 18 * (days - 1);
        } else if (place.equals("apartment")) {
            price = 25 * (days - 1);
            if (days < 10){
                price = price - (price * 0.30);
            } else if (days >= 10 && days <= 15 ) {
                price = price - (price * 0.35);
            } else if (days > 15) {
                price = price - (price * 0.50);
            }
        } else if (place.equals("president apartment")) {
            price = 35 * (days - 1);
            if (days < 10){
                price = price - (price * 0.10);
            } else if (days >= 10 && days <= 15) {
                price = price - (price * 0.15);
            } else if (days > 15) {
                price = price - (price * 0.20);
            }
        }

        if (rating.equals("positive")){
            price = price + (price * 0.25);
        } else if (rating.equals("negative")) {
            price = price - (price * 0.10);
        }
        System.out.printf("%.2f%n", price);

    }
}
