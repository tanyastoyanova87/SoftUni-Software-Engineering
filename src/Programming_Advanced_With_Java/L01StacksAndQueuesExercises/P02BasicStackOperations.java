package Programming_Advanced_With_Java.L01StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(stack::push);

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
