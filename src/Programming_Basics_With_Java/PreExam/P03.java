package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dancersCount = Integer.parseInt(scanner.nextLine());
        double pointsCount = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double sum = 0;
        double charity = 0;
        double leftMoney = 0;
        double moneyPerDancer = 0;
        if (place.equals("Bulgaria")){
            sum = dancersCount * pointsCount;

            if (season.equals("summer")){
                sum = sum - sum * 0.05;
            } else if (season.equals("winter")) {
                sum = sum - sum * 0.08;
            }
            charity = 0.75 * sum;
            leftMoney = sum - charity;
            moneyPerDancer = leftMoney / dancersCount;



        } else if (place.equals("Abroad")) {
            sum = dancersCount * pointsCount;
            double totalSum = sum + sum * 0.50;

            if (season.equals("summer")){
                totalSum = totalSum - totalSum * 0.10;
            } else if (season.equals("winter")) {
                totalSum = totalSum - totalSum * 0.15;
            }
            charity = 0.75 * totalSum;
            leftMoney = totalSum - charity;
            moneyPerDancer = leftMoney / dancersCount;
        }
        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f%n", moneyPerDancer);
    }
}
