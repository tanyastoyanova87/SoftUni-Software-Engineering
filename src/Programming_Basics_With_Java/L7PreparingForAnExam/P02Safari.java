package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double neededGasLitres = Double.parseDouble(scanner.nextLine());
        String dayOfWeekend = scanner.nextLine();

        double gasPrice = neededGasLitres * 2.10;
        double allPrice = gasPrice + 100;

        if (dayOfWeekend.equals("Saturday")){
            allPrice = allPrice * 0.90;
        } else if (dayOfWeekend.equals("Sunday")) {
            allPrice = allPrice * 0.80;
        }
        double diff = Math.abs(budget - allPrice);
        if (budget >= allPrice){
            System.out.printf("Safari time! Money left: %.2f lv.%n", diff);
        }else {
            System.out.printf("Not enough money! Money needed: %.2f lv.%n", diff);
        }
    }
}
