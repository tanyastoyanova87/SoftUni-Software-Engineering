package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotations ; i++) {
            int firstElement = numbers[0];

            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
