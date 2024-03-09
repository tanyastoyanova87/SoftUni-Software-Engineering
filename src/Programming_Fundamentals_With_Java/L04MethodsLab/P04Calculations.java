package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        if (operation.equals("add")) {
            printCalculationAdd(num1, num2);

        } else if (operation.equals("multiply")) {
            printCalculationMultiply(num1, num2);

        } else if (operation.equals("subtract")) {
            printCalculationSubtract(num1, num2);

        } else if (operation.equals("divide")) {
            printCalculationDivide(num1, num2);
        }
    }

    public static void printCalculationAdd(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public static void printCalculationMultiply(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public static void printCalculationSubtract(int num1, int num2) {
        System.out.println(num1 - num2);

    }

    public static void printCalculationDivide(int num1, int num2) {
        System.out.println(num1 / num2);
    }
}
