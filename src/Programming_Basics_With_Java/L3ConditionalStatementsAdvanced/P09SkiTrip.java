package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String review = scanner.nextLine();

        int nights = days - 1;
        double price = 0;

        switch (roomType){
            case "room for one person":
                if (days < 10){
                    price = nights * 18;
                }
                break;
            case "apartment":
                price = nights * 25;
                if (days < 10){
                    price = price - price * 0.3;
                }else if (days <= 15){
                    price = price - price * 0.35;
                }else {
                    price = price - price * 0.5;
                }
                break;
            case "president apartment":
                price = nights * 35;
                if (days < 10){
                    price = price - price * 0.1;
                }else if (days <= 15){
                    price = price - price * 0.15;
                }else {
                    price = price - price * 0.20;
                }
                break;
        }

        if (review.equals("positive")){
            price = price  + price * 0.25;
        }else {
            price = price - price * 0.1;
        }
        System.out.printf("%.2f", price);
    }
}
