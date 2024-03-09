package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);

        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredientsStack::push);


        Map<String, Integer> cookedFood = new HashMap<>();
        cookedFood.put("Biscuit", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pastry", 0);
        cookedFood.put("Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.poll();
            int currentIngredient = ingredientsStack.pop();

            int result = currentLiquid + currentIngredient;
            switch (result) {
                case 25:
                    cookedFood.put("Biscuit", cookedFood.get("Biscuit") + 1);
                    break;
                case 50:
                    cookedFood.put("Cake", cookedFood.get("Cake") + 1);
                    break;
                case 75:
                    cookedFood.put("Pastry", cookedFood.get("Pastry") + 1);
                    break;
                case 100:
                    cookedFood.put("Pie", cookedFood.get("Pie") + 1);
                    break;
                default:
                    currentIngredient += 3;
                    ingredientsStack.push(currentIngredient);
            }
        }

        if (cookedFood.get("Biscuit") > 0 && cookedFood.get("Cake") > 0 && cookedFood.get("Pastry") > 0 &&
                cookedFood.get("Pie") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String collect = liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + collect);
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String collect = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + collect);
        }

        System.out.printf("Biscuit: %d%n", cookedFood.get("Biscuit"));
        System.out.printf("Cake: %d%n", cookedFood.get("Cake"));
        System.out.printf("Pie: %d%n", cookedFood.get("Pie"));
        System.out.printf("Pastry: %d%n", cookedFood.get("Pastry"));
    }
}
