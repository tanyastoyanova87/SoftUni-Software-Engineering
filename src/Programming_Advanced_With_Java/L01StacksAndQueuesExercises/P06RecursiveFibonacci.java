package Programming_Advanced_With_Java.L01StacksAndQueuesExercises;

import java.util.Scanner;

public class P06RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        memory = new long[number + 1];

        long result = (fib(number));

        System.out.println(result);
    }

    private static long fib(long number) {
        if (number < 2) {
            return 1;
        }

        if (memory[(int) number] != 0) {
            return memory[(int) number];

        }
        memory[(int) number] = fib(number - 2) + fib(number - 1);
        return memory[(int) number];
    }
}
