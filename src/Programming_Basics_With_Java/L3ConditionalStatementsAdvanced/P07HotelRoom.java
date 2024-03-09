package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0;
        double apartmentPrice = 0;

        switch (month){
            case "May":
            case "October":
                studioPrice = nightsCount * 50;
                apartmentPrice = nightsCount * 65;
                if (nightsCount > 14){
                    studioPrice = studioPrice * 0.7;
                    apartmentPrice = apartmentPrice * 0.9;
                }else if (nightsCount > 7) {
                    studioPrice = studioPrice * 0.95;
                }
                break;
            case "June":
            case "September":
                studioPrice = nightsCount * 75.20;
                apartmentPrice = nightsCount * 68.70;
                if (nightsCount > 14){
                    studioPrice = studioPrice * 0.80;
                    apartmentPrice = apartmentPrice * 0.9;
                }
                break;
            case "July":
            case "August":
                studioPrice = nightsCount * 76;
                apartmentPrice = nightsCount * 77;
                if (nightsCount > 14){
                    apartmentPrice = apartmentPrice * 0.9;
                }
                break;
        }

        System.out.printf("Apartment: %.2f lv.%n", apartmentPrice);
        System.out.printf("Studio: %.2f lv.%n", studioPrice);
    }
}
