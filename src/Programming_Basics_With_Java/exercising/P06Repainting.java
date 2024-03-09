package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededNylonKqM = Integer.parseInt(scanner.nextLine());
        int neededPaintLitres = Integer.parseInt(scanner.nextLine());
        int thinnerLitres = Integer.parseInt(scanner.nextLine());
        int hoursForTheWork = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (neededNylonKqM + 2) * 1.50;
        double paintPrice = (neededPaintLitres + neededPaintLitres * 0.10) * 14.50;
        double thinnerPrice = thinnerLitres * 5;
        double allPrice = nylonPrice + paintPrice + thinnerPrice + 0.40;

        double oneHourWork = 0.30 * allPrice;
        double workPrice = oneHourWork * hoursForTheWork;

        double totalPrice = allPrice + workPrice;
        System.out.println(totalPrice);
    }
}
