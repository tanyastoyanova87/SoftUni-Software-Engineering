package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCount = Integer.parseInt(scanner.nextLine());
        int eggsCount = Integer.parseInt(scanner.nextLine());
        int biscuitsKg = Integer.parseInt(scanner.nextLine());

        double priceEasterBread = easterBreadCount * 3.20;
        double eggsPrice = eggsCount * 4.35;
        double biscuitsPrice = biscuitsKg * 5.40;
        double paintPrice = eggsCount * 12 * 0.15;
        double totalPrice = priceEasterBread + eggsPrice + biscuitsPrice + paintPrice;

        System.out.printf("%.2f%n", totalPrice);
    }
}
