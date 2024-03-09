package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegetarianMenu = Integer.parseInt(scanner.nextLine());

        double chickenPrice = chickenMenu * 10.35;
        double fishPrice = fishMenu * 12.40;
        double vegPrice = vegetarianMenu * 8.15;

        double allPrice = chickenPrice + fishPrice + vegPrice;
        double dessertPrice = 0.20 * allPrice;

        double totalPrice = allPrice + dessertPrice + 2.50;

        System.out.println(totalPrice);
    }
}
