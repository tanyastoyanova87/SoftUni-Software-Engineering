package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P06Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (nylon + 2) * 1.50;
        double paintPrice = (paint + (paint * 0.10)) * 14.50;
        double thinnerPrice = thinner * 5.00;

        double fullPrice = nylonPrice + paintPrice + thinnerPrice + 0.40;
        double builders = (fullPrice * 0.30) * hours;

        double finalSum = fullPrice + builders;

        System.out.println(finalSum);


    }
}
