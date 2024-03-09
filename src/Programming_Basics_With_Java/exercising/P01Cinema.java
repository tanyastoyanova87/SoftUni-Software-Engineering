package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeProjection = scanner.nextLine();
        int lines = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (typeProjection.equals("Premiere")){
            price = 12 * lines * columns;
            
        } else if (typeProjection.equals("Normal")) {
            price = 7.5 * lines * columns;

        }else if (typeProjection.equals("Discount")){
            price = 5 * lines * columns;
        }
        System.out.printf("%.2f leva%n", price);
    }
}
