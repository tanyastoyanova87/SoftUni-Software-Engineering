package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double extraClothes = Double.parseDouble(scanner.nextLine());

        double decor = 0.10 * movieBudget;
        double extrasClothesPrice = extras * extraClothes;

        if (extras > 150){
            extrasClothesPrice = extrasClothesPrice - (extrasClothesPrice * 0.10);
        }
        double totalPrice = decor + extrasClothesPrice;

        double neededOrLeftMoney = Math.abs(totalPrice - movieBudget);
        if (totalPrice > movieBudget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.%n", neededOrLeftMoney);
        }else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.%n", neededOrLeftMoney);
        }
    }
}
