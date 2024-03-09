package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double videoCardsSum = videoCards * 250;
        double processorsPrice = videoCardsSum * 0.35;
        double processorsSum = processors * processorsPrice;
        double ramPrice = videoCardsSum * 0.1;
        double ramSum = ram * ramPrice;

        double fullSum = videoCardsSum + processorsSum + ramSum;

        if (videoCards > processors){
            fullSum = fullSum - (fullSum * 0.15);
        }

        if (budget >= fullSum){
            double left = budget - fullSum;
            System.out.printf("You have %.2f leva left!", left);

        } else{
            double neededSum = fullSum - budget;
            System.out.printf("Not enough money! You need %.2f leva more!", neededSum);
        }
    }
}
