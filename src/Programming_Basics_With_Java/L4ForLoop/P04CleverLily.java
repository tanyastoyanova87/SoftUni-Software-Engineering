package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double washerPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        int evenSumAddition = 10;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += evenSumAddition;
                evenSumAddition += 10;
                sum -= 1;
            } else {
                sum += toyPrice;
            }
        }

        double diff = Math.abs(sum - washerPrice);

        if (sum >= washerPrice) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
