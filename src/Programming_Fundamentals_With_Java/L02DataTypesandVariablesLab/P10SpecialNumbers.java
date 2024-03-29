package Programming_Fundamentals_With_Java.L02DataTypesandVariablesLab;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;

            while (number > 0) {

                int lasDigit = number % 10;
                sum += lasDigit;
                number = number / 10;
            }
                if (sum == 5 || sum == 7 || sum == 11) {
                    System.out.printf("%d -> True%n", i);
                } else {
                    System.out.printf("%d -> False%n", i);
                }
        }
    }
}