package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (flowers){
            case "Roses":
                price = flowersCount * 5;
                if (flowersCount > 80){
                    price = price * 0.9;
                }
                break;
            case "Dahlias":
                price = flowersCount * 3.80;
                if (flowersCount > 90){
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price = flowersCount * 2.80;
                if (flowersCount > 80){
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price = flowersCount * 3;
                if (flowersCount < 120){
                    price = price + price * 0.15;
                }
                break;
            case "Gladiolus":
                price = flowersCount * 2.50;
                if (flowersCount < 80){
                    price = price + price * 0.20;
                }
                break;
        }

        double diff = Math.abs(price - budget);

        if (budget >= price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowers, diff);
        }else {
            System.out.printf("Not enough money, you need %.2f leva more.", diff);
        }
    }
}
