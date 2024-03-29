package Programming_Advanced_With_Java.L01StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06RecursiveFibonacciWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        if (num < 2) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < num; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }

        System.out.println(stack.pop());
    }
}
