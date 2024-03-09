package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int numSum = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[j];
                if (currentNum + num == numSum){
                    System.out.println(currentNum + " " + num);
                }
            }
        }
    }
}
