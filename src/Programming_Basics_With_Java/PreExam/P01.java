package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int nightsCount = Integer.parseInt(scanner.nextLine());
        int cardsTransport = Integer.parseInt(scanner.nextLine());
        int ticketsMuseum = Integer.parseInt(scanner.nextLine());

        double nightPricePerPerson = nightsCount * 20;
        double cardsPricePerPerson = cardsTransport * 1.60;
        double ticketsPricePerPerson = ticketsMuseum * 6;

        double totalPricePerPerson = nightPricePerPerson + cardsPricePerPerson + ticketsPricePerPerson;
        double totalPrice = totalPricePerPerson * people;
        double totalPricePlusPercent = totalPrice + totalPrice * 0.25;

        System.out.printf("%.2f%n", totalPricePlusPercent);
    }
}
