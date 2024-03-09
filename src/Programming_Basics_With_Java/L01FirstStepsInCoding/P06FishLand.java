package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P06FishLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPriceForOneKg = Double.parseDouble(scanner.nextLine());
        double spratPriceForOneKg = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        int clamKg = Integer.parseInt(scanner.nextLine());

        double bonitoPrice = mackerelPriceForOneKg + (mackerelPriceForOneKg * 0.60);
        double bonitoSum = bonitoKg * bonitoPrice;
        double scadPrice = spratPriceForOneKg + (spratPriceForOneKg * 0.80);
        double scadSum = scadKg * scadPrice;
        double clamSum = clamKg * 7.50;
        double fullPrice = bonitoSum + scadSum + clamSum;

        System.out.printf("%.2f", fullPrice);

    }
}
