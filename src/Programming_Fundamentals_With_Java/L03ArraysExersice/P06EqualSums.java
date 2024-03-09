package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                                .split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                leftSum += numbers[leftIndex];
            }

            for (int rightIndex = i + 1; rightIndex < numbers.length; rightIndex++) {
                rightSum += numbers[rightIndex];
            }
            if (leftSum == rightSum){
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
