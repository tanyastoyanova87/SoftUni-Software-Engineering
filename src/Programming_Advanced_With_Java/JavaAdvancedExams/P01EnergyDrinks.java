package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsStack = new ArrayDeque<>();

        List<Integer> milligramsCoffee = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        milligramsCoffee.forEach(milligramsStack::push);

        Deque<Integer> energyDrinksQueue = new ArrayDeque<>();

        List<Integer> energyDrinks = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        energyDrinks.forEach(energyDrinksQueue::offer);


        int totalCaffeine = 0;
        while (!milligramsStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
            int currentMilligrams = milligramsStack.peek();
            int currentEnergyDrinks = energyDrinksQueue.peek();
            int result = currentMilligrams * currentEnergyDrinks;
            if (result <= 300 && totalCaffeine + result <= 300) {
                totalCaffeine += result;
                milligramsStack.pop();
                energyDrinksQueue.poll();

            } else {
                milligramsStack.pop();
                energyDrinksQueue.poll();
                energyDrinksQueue.offer(currentEnergyDrinks);
                totalCaffeine -= 30;
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }
            }
        }

        if (!energyDrinksQueue.isEmpty()) {
            System.out.print("Drinks left: ");
            List<String> drinksLeft = new ArrayList<>();
            energyDrinksQueue.forEach(e -> drinksLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", drinksLeft));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", totalCaffeine);
    }
}
