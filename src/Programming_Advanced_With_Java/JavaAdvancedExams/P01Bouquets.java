package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tulipsStack::push);

        Deque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(daffodilsQueue::offer);

        int bouquets = 0;
        int storedFlowers = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int currentTulip = tulipsStack.pop();
            int currentDaffodil = daffodilsQueue.pop();

            int sum = currentTulip + currentDaffodil;
            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                bouquets++;
            } else {
                storedFlowers += sum;
            }
        }

        while (storedFlowers >= 15) {
            bouquets++;
            storedFlowers -= 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
