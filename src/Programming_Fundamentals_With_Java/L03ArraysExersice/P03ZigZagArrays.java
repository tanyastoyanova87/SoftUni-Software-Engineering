package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] numbers = input.split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            if (i % 2 != 0){
               firstArray[i - 1] = num1;
               secondArray[i - 1] = num2;
            }else {
                secondArray[i - 1] = num1;
                firstArray[i - 1] = num2;
            }
        }
        for (int number : firstArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
