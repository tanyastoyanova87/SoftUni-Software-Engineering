package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredientsCountInABucketQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsCountInABucketQueue::offer);

        Deque<Integer> freshnessLevelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(freshnessLevelStack::push);

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;
        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsCountInABucketQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {

            int currentIngredientCount = ingredientsCountInABucketQueue.peek();
            int currentFreshness = freshnessLevelStack.peek();

            if (currentIngredientCount == 0) {
                ingredientsCountInABucketQueue.poll();
                continue;
            }
            int result = currentIngredientCount * currentFreshness;
            if (result == 150) {
                pearSour++;
                cocktails.put("Pear Sour", pearSour);
                ingredientsCountInABucketQueue.poll();
                freshnessLevelStack.pop();
            } else if (result == 250) {
                theHarvest++;
                cocktails.put("The Harvest", theHarvest);
                ingredientsCountInABucketQueue.poll();
                freshnessLevelStack.pop();
            } else if (result == 300) {
                appleHinny++;
                cocktails.put("Apple Hinny", appleHinny);
                ingredientsCountInABucketQueue.poll();
                freshnessLevelStack.pop();
            } else if (result == 400) {
                highFashion++;
                cocktails.put("High Fashion", highFashion);
                ingredientsCountInABucketQueue.poll();
                freshnessLevelStack.pop();
            } else {
                freshnessLevelStack.pop();
                currentIngredientCount += 5;
                ingredientsCountInABucketQueue.poll();
                ingredientsCountInABucketQueue.offer(currentIngredientCount);
            }
        }

        if (pearSour > 0 && theHarvest > 0 && appleHinny > 0 && highFashion > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsCountInABucketQueue.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : ingredientsCountInABucketQueue) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktails.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.printf("# %s --> %d%n", e.getKey(), e.getValue());
                });
    }
}
