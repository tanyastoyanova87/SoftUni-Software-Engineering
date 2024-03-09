package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result;
        String evenOrOdd;
        if (operator.equals("+")) {
            result = n1 + n2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %s %d = %.0f - %s%n", n1, operator, n2, result, evenOrOdd);
        } else if (operator.equals("-")) {
            result = n1 - n2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %s %d = %.0f - %s%n", n1, operator, n2, result, evenOrOdd);
        } else if (operator.equals("*")) {
            result = n1 * n2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %s %d = %.0f - %s%n", n1, operator, n2, result, evenOrOdd);

        } else if (operator.equals("/")) {
            result = n1 * 1.0 / n2;

            if (n1 == 0) {
                System.out.printf("Cannot divide %d by zero%n", n2);

            }else if (n2 == 0){
                System.out.printf("Cannot divide %d by zero%n", n1);

            }else {
                System.out.printf("%d / %d = %.2f%n", n1, n2, result);
            }

        } else if (operator.equals("%")) {
            result = n1 * 1.0 % n2;

            if (n1 == 0) {
                System.out.printf("Cannot divide %d by zero%n", n2);

            }else if (n2 == 0){
                System.out.printf("Cannot divide %d by zero%n", n1);

             }else {
                System.out.printf("%d %% %d = %.0f%n", n1, n2, result);
            }
        }
    }
}