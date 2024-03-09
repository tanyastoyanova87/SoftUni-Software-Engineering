package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstLootBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstLootBoxQueue::offer);

        Deque<Integer> secondLootBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondLootBoxStack::push);

        int totalValue = 0;
        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {
            int currentValueFirstBox = firstLootBoxQueue.peek();
            int currentValueSecondBox = secondLootBoxStack.peek();
            int result = currentValueFirstBox + currentValueSecondBox;
            if (result % 2 == 0) {
                totalValue += result;
                firstLootBoxQueue.poll();
                secondLootBoxStack.pop();
            } else {
                secondLootBoxStack.pop();
                firstLootBoxQueue.offer(currentValueSecondBox);
            }
        }

        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (totalValue >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", totalValue);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", totalValue);
        }
    }
}
