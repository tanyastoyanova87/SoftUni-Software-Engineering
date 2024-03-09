package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double allMoney = 0;
        int money = 0;
        int toy = 0;

        for (int i = 1; i <= age ; i++) {

            if (i % 2 == 0){
                money += 10;
                allMoney += money;
                allMoney -= 1;
            }else {
                toy++;
            }
        }
        allMoney = allMoney + (toy * toyPrice);

        double left = Math.abs(allMoney - washingMachinePrice);
        if (allMoney >= washingMachinePrice){
            System.out.printf("Yes! %.2f%n", left);
        }else {
            System.out.printf("No! %.2f%n", left);
        }
    }
}
