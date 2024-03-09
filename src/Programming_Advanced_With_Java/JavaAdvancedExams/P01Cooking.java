package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);

        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.poll();
            int currentIngredient = ingredientsStack.pop();

            int sum = currentLiquid + currentIngredient;
            if (sum == 25) {
                bread++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                fruitPie++;
            } else {
                currentIngredient += 3;
                ingredientsStack.push(currentIngredient);
            }
        }


        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        System.out.printf("Bread: %d%n", bread);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Fruit Pie: %d%n", fruitPie);
        System.out.printf("Pastry: %d%n", pastry);

    }
}
