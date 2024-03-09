package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double flourPriceKg = Double.parseDouble(scanner.nextLine());
        double flourKgs = Double.parseDouble(scanner.nextLine());
        double sugarKgs = Double.parseDouble(scanner.nextLine());
        int eggsShells = Integer.parseInt(scanner.nextLine());
        int yeastPackets = Integer.parseInt(scanner.nextLine());

        double sugarPrice = flourPriceKg - flourPriceKg * 0.25;
        double eggsShellsPrice = flourPriceKg + flourPriceKg * 0.10;
        double yeastPrice = sugarPrice - sugarPrice * 0.80;

        double flourPriceTotal = flourPriceKg * flourKgs;
        double sugarPriceTotal = sugarPrice * sugarKgs;
        double eggsPriceTotal = eggsShellsPrice * eggsShells;
        double yeastPriceTotal = yeastPrice * yeastPackets;

        double totalSum = flourPriceTotal + sugarPriceTotal + eggsPriceTotal + yeastPriceTotal;
        System.out.printf("%.2f%n", totalSum);
    }
}
