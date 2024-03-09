package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogPackages = Integer.parseInt(scanner.nextLine());
        int catPackages = Integer.parseInt(scanner.nextLine());

        double dogPrice = 2.50 * dogPackages;
        double catPrice = 4 * catPackages;
        double totalPrice = dogPrice + catPrice;

        System.out.println(totalPrice + " lv.");

    }
}
