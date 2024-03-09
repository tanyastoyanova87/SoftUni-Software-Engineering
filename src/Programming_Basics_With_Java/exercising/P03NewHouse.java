package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (flowerType.equals("Roses")){
            price = 5 * flowersCount;
            if (flowersCount > 80){
               price = price - (price * 0.10);
            }

        } else if (flowerType.equals("Dahlias")) {
            price = 3.80 * flowersCount;
            if (flowersCount > 90){
                price = price - (price * 0.15);
            }

        } else if (flowerType.equals("Tulips")) {
            price = 2.80 * flowersCount;
            if (flowersCount > 80){
                price = price - (price * 0.15);
            }
            
        } else if (flowerType.equals("Narcissus")) {
            price = 3 * flowersCount;
            if (flowersCount < 120){
                price = price + (price * 0.15);
            }
            
        } else if (flowerType.equals("Gladiolus")) {
            price = 2.50 * flowersCount;
            if (flowersCount < 80){
                price = price + (price * 0.20);
            }
        }
        double leftOrNeeded = Math.abs(price - budget);
        if (price <= budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.%n", flowersCount,
                    flowerType, leftOrNeeded);
        }else {
            System.out.printf("Not enough money, you need %.2f leva more.%n", leftOrNeeded);
        }
    }
}
