package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double clothes = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        clothes = extras * clothes;

        if (extras > 150){
            clothes = clothes - clothes * 0.1;
        }

        double decorClothes = decor + clothes;

        if (decorClothes > budget){
           double needed =(budget - decorClothes) * -1;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", needed);
        } else {
            double left = budget - decorClothes;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", left);
        }
    }
}
