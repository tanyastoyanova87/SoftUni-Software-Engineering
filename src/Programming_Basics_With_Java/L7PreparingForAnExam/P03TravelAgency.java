package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        String typePacket = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double pricePerDay = 0;

        boolean isValid = true;
        if (town.equals("Bansko") || town.equals("Borovets")) {
            if (typePacket.equals("withEquipment")) {

                if (vip.equals("yes")) {
                    pricePerDay = 100 * 0.90;
                } else {
                    pricePerDay = 100;
                }
            } else if (typePacket.equals("noEquipment")) {
                if (vip.equals("yes")) {
                    pricePerDay = 80 * 0.95;
                } else {
                    pricePerDay = 80;
                }
            } else {
                System.out.println("Invalid input!");
            }
        } else if (town.equals("Varna") || town.equals("Burgas")) {
            if (typePacket.equals("withBreakfast")) {
                if (vip.equals("yes")) {
                    pricePerDay = 130 * 0.88;
                } else {
                    pricePerDay = 130;
                }

            } else if (typePacket.equals("noBreakfast")) {
                if (vip.equals("yes")) {
                    pricePerDay = 100 * 0.93;
                } else {
                    pricePerDay = 100;
                }

            }else {
                isValid = false;
            }
        }else {
            isValid = false;
        }
        if (days < 1) {
            System.out.println("Days must be positive number!");
        } else if (!isValid) {
            System.out.println("Invalid input!");
        }else {
            if (days > 7){
            days = days - 1;
        }
            double totalPrice = pricePerDay * days;
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }

    }
}
