package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);

        Deque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(rosesQueue::offer);

        int wreath = 0;
        int storedFlowers = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int currentRose = rosesQueue.poll();
            int currentLily = liliesStack.pop();

            int sum = currentLily + currentRose;

            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                wreath++;
            } else {
                storedFlowers += sum;
            }
        }

        while (storedFlowers >= 15) {
            wreath++;
            storedFlowers -= 15;
        }

        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreath);
        }
    }
}
