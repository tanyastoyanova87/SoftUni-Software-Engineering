package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQuantityQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(milkQuantityQueue::offer);

        Deque<Double> cacaoPowderQuantityStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(cacaoPowderQuantityStack::push);

        int milkChocolate = 0;
        int darkChocolate = 0;
        int bakingChocolate = 0;
        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkQuantityQueue.isEmpty() && !cacaoPowderQuantityStack.isEmpty()) {

            double currentMilkValue = milkQuantityQueue.peek();
            double currentCacaoValue = cacaoPowderQuantityStack.peek();

            int result = (int) ((currentCacaoValue / (currentMilkValue + currentCacaoValue)) * 100);

            if (result == 30) {
                milkChocolate++;
                chocolates.put("Milk Chocolate", milkChocolate);
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();

            } else if (result == 50) {
                darkChocolate++;
                chocolates.put("Dark Chocolate", darkChocolate);
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();

            } else if (result == 100) {
                bakingChocolate++;
                chocolates.put("Baking Chocolate", bakingChocolate);
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();

            } else {
                cacaoPowderQuantityStack.pop();
                currentMilkValue += 10;
                milkQuantityQueue.poll();
                milkQuantityQueue.offer(currentMilkValue);
            }
        }
        if (milkChocolate > 0 && darkChocolate > 0 && bakingChocolate > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
                });
    }
}
