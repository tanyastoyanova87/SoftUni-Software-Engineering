package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        double spendMoney = 0;
        String place = "";

        if (budget <= 100){
            destination = "Bulgaria";

            if (season.equals("summer")){
                spendMoney = 0.30 * budget;
                place = "Camp";

            } else if (season.equals("winter")) {
                spendMoney = 0.70 * budget;
                place = "Hotel";
            }
        } else if (budget <= 1000) {
            destination = "Balkans";

            if (season.equals("summer")){
                spendMoney = 0.40 * budget;
                place = "Camp";

            } else if (season.equals("winter")) {
                spendMoney = 0.80 * budget;
                place = "Hotel";
            }
        } else if (budget > 1000) {
            destination = "Europe";

            if (season.equals("summer") || season.equals("winter")){
                spendMoney = 0.90 * budget;
                place = "Hotel";
            }
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f%n", place, spendMoney);
    }
}
