package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0;
        double apartmentPrice = 0;
        if (month.equals("May") || month.equals("October")){
            studioPrice = 50 * nights;
            if (nights > 7 && nights < 14){
                studioPrice = studioPrice - (studioPrice * 0.05);
            } else if (nights > 14) {
                studioPrice = studioPrice - (studioPrice * 0.30);
            }
            apartmentPrice = 65 * nights;

        } else if (month.equals("June") || month.equals("September")) {
            studioPrice = 75.20 * nights;
            if (nights > 14){
                studioPrice = studioPrice - (studioPrice * 0.20);
            }
            apartmentPrice = 68.70 * nights;
            
        } else if (month.equals("July") || month.equals("August")) {
            studioPrice = 76 * nights;
            apartmentPrice = 77 * nights;

        }
        if (nights > 14){
            apartmentPrice = apartmentPrice - (apartmentPrice * 0.10);
        }
        System.out.printf("Apartment: %.2f lv.%n", apartmentPrice);
        System.out.printf("Studio: %.2f lv.%n", studioPrice);
    }
}
