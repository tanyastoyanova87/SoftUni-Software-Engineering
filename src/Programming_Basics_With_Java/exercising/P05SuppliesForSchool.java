package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int penPackagesCount = Integer.parseInt(scanner.nextLine());
        int markersPackagesCount = Integer.parseInt(scanner.nextLine());
        int cleaningLitres = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        double penPrice = penPackagesCount * 5.80;
        double markersPrice = markersPackagesCount * 7.20;
        double cleaningPrice = cleaningLitres * 1.20;

        double allPrice = penPrice + markersPrice + cleaningPrice;

        double totalPrice = allPrice - (allPrice * percentDiscount / 100);
        System.out.println(totalPrice);
    }
}
