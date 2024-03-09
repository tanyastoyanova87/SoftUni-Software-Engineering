package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogPackages = Integer.parseInt(scanner.nextLine());
        int catPackages = Integer.parseInt(scanner.nextLine());
        double dogPrice = dogPackages * 2.50;
        double catPrice = catPackages * 4;

        double fullPrice = dogPrice + catPrice;

        System.out.println(fullPrice);


    }
}
