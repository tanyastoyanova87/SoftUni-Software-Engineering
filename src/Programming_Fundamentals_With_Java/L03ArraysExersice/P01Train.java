package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] currentNum = new int[n];

        int sum = 0;
        for (int i = 0; i < n ; i++) {
            currentNum[i] = Integer.parseInt(scanner.nextLine());
            sum += currentNum[i];

            System.out.printf("%d ", currentNum[i]);
        }
        System.out.println();
        System.out.println(sum);
    }
}
