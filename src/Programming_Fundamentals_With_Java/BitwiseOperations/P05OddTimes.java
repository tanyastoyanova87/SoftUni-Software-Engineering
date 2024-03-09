package Programming_Fundamentals_With_Java.BitwiseOperations;

import java.util.Arrays;
import java.util.Scanner;

public class P05OddTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        for (int num : numbers) {
            result = result ^ num;
        }

        System.out.println(result);
    }
}
