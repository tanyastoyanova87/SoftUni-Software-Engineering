package Programming_Fundamentals_With_Java.L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P13RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int result = 2 * i + 1;
            System.out.println(result);
            sum += result;
        }
        System.out.printf("Sum: %d%n", sum);

    }
}
