package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01OffRoadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] initialFuel = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] consumptionIndexes = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] quantities = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> initialFuelDeque = new ArrayDeque<>();
        Arrays.stream(initialFuel).forEach(initialFuelDeque::push);

        Deque<Integer> consumptionIndexesDeque = new ArrayDeque<>();
        Arrays.stream(consumptionIndexes).forEach(consumptionIndexesDeque::offer);

        Deque<Integer> quantitiesDeque = new ArrayDeque<>();
        Arrays.stream(quantities).forEach(quantitiesDeque::offer);

        List<String> altitudes = new ArrayList<>();
        int altitude = 0;
        while (!initialFuelDeque.isEmpty() || !consumptionIndexesDeque.isEmpty() || !quantitiesDeque.isEmpty()) {
            altitude++;
            if (initialFuelDeque.getFirst() - consumptionIndexesDeque.getFirst() >= quantitiesDeque.getFirst()) {
                System.out.printf("John has reached: Altitude %d%n", altitude);
                altitudes.add(String.valueOf(altitude));
                initialFuelDeque.pop();
                consumptionIndexesDeque.poll();
                quantitiesDeque.poll();
            } else {
                System.out.printf("John did not reach: Altitude %d%n", altitude);
                System.out.println("John failed to reach the top.");
                break;
            }
        }
        if (altitudes.isEmpty()) {
            System.out.println("John didn't reach any altitude.");
        } else if (!altitudes.isEmpty()) {
            System.out.print("Reached altitudes: Altitude ");
            System.out.print(String.join(", Altitude ", altitudes));
        } else {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }

    }
}
