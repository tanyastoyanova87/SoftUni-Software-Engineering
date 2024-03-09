package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstMagicBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstMagicBoxQueue::offer);

        Deque<Integer> secondMagicBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondMagicBoxStack::push);

        int totalSum = 0;
        while (!firstMagicBoxQueue.isEmpty() && !secondMagicBoxStack.isEmpty()) {
            int currentValueFirstMagicBox = firstMagicBoxQueue.peek();
            int currentValueSecondMagicBox = secondMagicBoxStack.peek();
            int sum = currentValueFirstMagicBox + currentValueSecondMagicBox;
            if (sum % 2 == 0) {
                firstMagicBoxQueue.poll();
                secondMagicBoxStack.pop();
                totalSum += sum;
            } else {
                secondMagicBoxStack.pop();
                firstMagicBoxQueue.offer(currentValueSecondMagicBox);
            }
        }

        if (firstMagicBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", totalSum);
        }
    }
}
