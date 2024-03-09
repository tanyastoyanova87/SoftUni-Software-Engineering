package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03EasterTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String dates = scanner.nextLine();
        int nightsSpend = Integer.parseInt(scanner.nextLine());

        double priceNight = 0;

        if (destination.equals("France")){

            if (dates.equals("21-23")){
                priceNight = 30;
            }else if (dates.equals("24-27")){
                priceNight = 35;
            } else if (dates.equals("28-31")) {
                priceNight = 40;
            }

        } else if (destination.equals("Italy")) {

            if (dates.equals("21-23")){
                priceNight = 28;
            }else if (dates.equals("24-27")){
                priceNight = 32;
            } else if (dates.equals("28-31")) {
                priceNight = 39;
            }

        } else if (destination.equals("Germany")) {

            if (dates.equals("21-23")){
                priceNight = 32;
            }else if (dates.equals("24-27")){
                priceNight = 37;
            } else if (dates.equals("28-31")) {
                priceNight = 43;
            }
        }
        double totalPrice = nightsSpend * priceNight;
        System.out.printf("Easter trip to %s : %.2f leva.%n", destination, totalPrice);
    }
}
