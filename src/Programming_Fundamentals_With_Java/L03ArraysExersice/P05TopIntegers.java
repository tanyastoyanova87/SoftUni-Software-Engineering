package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];

            boolean isBigger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                int numbersAfter = numbers[j];
                if (currentNum <= numbersAfter){
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.printf("%d ", currentNum);
            }
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}
