package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textilesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(textilesQueue::offer);

        Deque<Integer> medicamentStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(medicamentStack::push);

        int patch = 0;
        int bandage = 0;
        int medKit = 0;

        Map<String, Integer> createdItems = new TreeMap<>();

        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int currentTextile = textilesQueue.peek();
            int currentMedicament = medicamentStack.peek();

            int sum = currentTextile + currentMedicament;
            if (sum == 30) {
                patch++;
                createdItems.put("Patch", patch);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sum == 40) {
                bandage++;
                createdItems.put("Bandage", bandage);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sum == 100) {
                medKit++;
                createdItems.put("MedKit", medKit);
                textilesQueue.poll();
                medicamentStack.pop();
            } else {
                if (sum > 100) {
                    medKit++;
                    createdItems.put("MedKit", medKit);
                    textilesQueue.poll();
                    medicamentStack.pop();
                    int current = medicamentStack.pop();
                    sum -= 100;
                    medicamentStack.push(current + sum);
                } else {
                    textilesQueue.poll();
                    currentMedicament += 10;
                    medicamentStack.pop();
                    medicamentStack.push(currentMedicament);
                }
            }
        }

        if (textilesQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }

        createdItems.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
            System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        });

        if (!medicamentStack.isEmpty()) {
            String collect = medicamentStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Medicaments left: " + collect);

        }
        if (!textilesQueue.isEmpty()) {
            String collect = textilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Textiles left: " + collect);
        }
    }
}
