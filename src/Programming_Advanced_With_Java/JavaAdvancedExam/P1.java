package Programming_Advanced_With_Java.JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneyInPocketStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(moneyInPocketStack::push);

        Deque<Integer> foodPricesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(foodPricesQueue::offer);

        int foodCount = 0;
        while (!moneyInPocketStack.isEmpty() && !foodPricesQueue.isEmpty()) {
            int currentPrice = foodPricesQueue.poll();
            int currentMoney = moneyInPocketStack.pop();

            if (currentMoney == currentPrice) {
                foodCount++;
            } else if (currentMoney > currentPrice) {
                foodCount++;
                int difference = currentMoney - currentPrice;
                if (!moneyInPocketStack.isEmpty() && !foodPricesQueue.isEmpty()) {
                    int current = moneyInPocketStack.pop();
                    moneyInPocketStack.push(current + difference);
                }

            }
        }

        if (foodCount >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", foodCount);
        } else if (foodCount == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else {
            if (foodCount == 1) {
                System.out.printf("Henry ate: %d food.%n", foodCount);
            } else {
                System.out.printf("Henry ate: %d foods.%n", foodCount);

            }
        }
    }
}
