package Programming_Fundamentals_With_Java.L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int start = 1;
        for (int i = 1; i <= n ; i++) {
            System.out.println(start);
            sum += start;
            start += 2;

        }
        System.out.printf("Sum: %d%n", sum);
    }
}
