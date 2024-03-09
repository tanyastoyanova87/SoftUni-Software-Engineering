package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());

        double totalIncome = 0;
        String command = scanner.nextLine();
        while (!command.equals("Party!")){
            String cocktail = command;
            int cocktailCount = Integer.parseInt(scanner.nextLine());


            double cocktailPrice = cocktail.length() * cocktailCount;

            if (cocktailPrice % 2 != 0){
                cocktailPrice = cocktailPrice * 0.75;
            }

            totalIncome += cocktailPrice;
        if (totalIncome >= income){
            break;
        }
            command = scanner.nextLine();


        }
        if (income > totalIncome) {
            double diff = Math.abs(income - totalIncome);
            System.out.printf("We need %.2f leva more.%n", diff);
        }else {
        System.out.println("Target acquired.");

        }
        System.out.printf("Club income - %.2f leva.%n", totalIncome);
    }
}
