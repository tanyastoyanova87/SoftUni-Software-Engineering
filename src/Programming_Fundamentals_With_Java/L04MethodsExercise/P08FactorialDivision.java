package Programming_Fundamentals_With_Java.L04MethodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = Integer.parseInt(scanner.nextLine());
        long num2 = Integer.parseInt(scanner.nextLine());

        long firstNum = printFactorialDivision(num1);
        long secondNum = printFactorialDivision(num2);

        double result = firstNum * 1.0 / secondNum;

        System.out.printf("%.2f%n", result);
    }

    public static long printFactorialDivision (long number) {

        long factorial = 1;

        for (int i = 1; i <= number ; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
