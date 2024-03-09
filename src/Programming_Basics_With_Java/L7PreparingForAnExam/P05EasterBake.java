package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCount = Integer.parseInt(scanner.nextLine());
        int sugarCounter = 0;
        int flourCounter = 0;
        double neededSugarPackages = 0;
        double neededFlourPackages = 0;

        int maxNumSugar = Integer.MIN_VALUE;
        int maxNumFlour = Integer.MIN_VALUE;
        for (int i = 1; i <= easterBreadCount ; i++) {
            int sugarSpendGrams = Integer.parseInt(scanner.nextLine());
            int flourSpendGrams = Integer.parseInt(scanner.nextLine());

            sugarCounter += sugarSpendGrams;
            neededSugarPackages = Math.ceil(sugarCounter * 1.0 / 950);
            flourCounter += flourSpendGrams;
            neededFlourPackages = Math.ceil(flourCounter * 1.0 / 750);

            if (maxNumSugar < sugarSpendGrams){
                maxNumSugar = sugarSpendGrams;
            }
            if (maxNumFlour < flourSpendGrams){
                maxNumFlour = flourSpendGrams;
            }
        }
        System.out.printf("Sugar: %.0f%n", neededSugarPackages);
        System.out.printf("Flour: %.0f%n", neededFlourPackages);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.%n", maxNumFlour, maxNumSugar);
    }
}
