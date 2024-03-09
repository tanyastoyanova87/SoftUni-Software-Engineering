package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumEven = 0;
        int oddSum = 0;
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0){
                sumEven += num;
            }else {
                oddSum += num;
            }
        }
        if (sumEven == oddSum){
            System.out.println("Yes");
            System.out.printf("Sum = %d%n", sumEven);
        }else {
            int diff = Math.abs(sumEven - oddSum);
            System.out.println("No");
            System.out.printf("Diff = %d%n", diff);
        }
    }
}
