package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(steelQueue::offer);

        Deque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(carbonStack::push);

        Map<String, Integer> swords = new TreeMap<>();
        int Gladius = 0;
        int Shamshir = 0;
        int Katana = 0;
        int Sabre = 0;
        int totalNumberSwords = 0;
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int currentSteel = steelQueue.peek();
            int currentCarbon = carbonStack.peek();

            int sum = currentSteel + currentCarbon;
            if (sum == 70) {
                Gladius++;
                totalNumberSwords++;
                swords.put("Gladius", Gladius);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == 80) {
                Shamshir++;
                totalNumberSwords++;
                swords.put("Shamshir", Shamshir);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == 90) {
                Katana++;
                totalNumberSwords++;
                swords.put("Katana", Katana);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == 110) {
                Sabre++;
                totalNumberSwords++;
                swords.put("Sabre", Sabre);
                steelQueue.poll();
                carbonStack.pop();
            } else {
                steelQueue.poll();
                currentCarbon += 5;
                carbonStack.pop();
                carbonStack.push(currentCarbon);
            }
        }

        if (!swords.isEmpty()) {
            System.out.printf("You have forged %d swords.%n", totalNumberSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            List<String> steelLeft = new ArrayList<>();
            steelQueue.forEach(e -> steelLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", steelLeft));
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            List<String> carbonLeft = new ArrayList<>();
            carbonStack.forEach(e -> carbonLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", carbonLeft));
        }

        swords.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
    }
}
