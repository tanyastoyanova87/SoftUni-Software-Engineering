package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 1; i <= n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum = sum + number;
            if (number > maxNum){
                maxNum = number;
            }
        }
        int sumWithoutMax = sum - maxNum;

        if (sumWithoutMax == maxNum){
            System.out.println("Yes");
            System.out.printf("Sum = %d%n", sumWithoutMax);
        }else {
            System.out.println("No");
            int diff = Math.abs(maxNum - sumWithoutMax);
            System.out.printf("Diff = %d%n", diff);
        }
    }
}
