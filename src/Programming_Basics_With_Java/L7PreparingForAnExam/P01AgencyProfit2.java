package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01AgencyProfit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int adultTicketsCount = Integer.parseInt(scanner.nextLine());
        int kidsTicketsCount = Integer.parseInt(scanner.nextLine());
        double priceAdultTicket = Double.parseDouble(scanner.nextLine());
        double feePrice = Double.parseDouble(scanner.nextLine());

        double kidsTicketPrice = priceAdultTicket - (priceAdultTicket * 0.70);
        double kidsPriceFee = kidsTicketPrice + feePrice;
        double adultPriceFee = priceAdultTicket + feePrice;

        double ticketsTotal = adultTicketsCount * adultPriceFee + kidsTicketsCount * kidsPriceFee;
        double totalProfit = 0.20 * ticketsTotal;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.%n", name, totalProfit);
    }
}
