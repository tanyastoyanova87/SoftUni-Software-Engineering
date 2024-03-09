package Programming_Fundamentals_With_Java.L03ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int evanSum = 0;
        int oddSum = 0;

        for (int number : numbers){
            if (number % 2 == 0){
                evanSum += number;
            }else {
                oddSum += number;
            }
        }
        System.out.println(evanSum - oddSum);
    }
}
