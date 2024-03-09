package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P04CleverLily2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int pricePerToy = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int sumWithoutAddition = 10;
        int countToys = 0;
        for (int i = 1; i <= age ; i++) {

            if (i % 2 == 0) {
                sum += sumWithoutAddition;
                sumWithoutAddition += 10;
                sum--;
            } else {
                countToys++;
            }
        }
        int soldToys = countToys * pricePerToy;
        int allMoney = soldToys + sum;

        double diff = Math.abs(allMoney - washingMachinePrice);
        if (allMoney >= washingMachinePrice) {
            System.out.printf("Yes! %.2f%n", diff);
        }else {
            System.out.printf("No! %.2f%n", diff);
        }
    }
}
