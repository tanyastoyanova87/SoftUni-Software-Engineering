package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materialsBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialsBoxStack::push);

        Deque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicLevelQueue::offer);

        int doll = 0;
        int woodenTrain = 0;
        int teddyBear = 0;
        int bicycle = 0;

        Map<String, Integer> craftedToys = new TreeMap<>();

        while (!materialsBoxStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int currentMaterials = materialsBoxStack.peek();
            int currentMagicLevel = magicLevelQueue.peek();

            if (currentMaterials == 0 && currentMagicLevel == 0) {
                magicLevelQueue.poll();
                materialsBoxStack.pop();
                continue;
            }
            if (currentMaterials == 0) {
                materialsBoxStack.pop();
                continue;
            }
            if (currentMagicLevel == 0) {
                magicLevelQueue.poll();
                continue;
            }
            int result = currentMaterials * currentMagicLevel;

            if (result == 150) {
                magicLevelQueue.poll();
                materialsBoxStack.pop();
                doll++;
                craftedToys.put("Doll", doll);
            } else if (result == 250) {
                magicLevelQueue.poll();
                materialsBoxStack.pop();
                woodenTrain++;
                craftedToys.put("Wooden train", woodenTrain);
            } else if (result == 300) {
                magicLevelQueue.poll();
                materialsBoxStack.pop();
                teddyBear++;
                craftedToys.put("Teddy bear", teddyBear);
            } else if (result == 400) {
                magicLevelQueue.poll();
                materialsBoxStack.pop();
                bicycle++;
                craftedToys.put("Bicycle", bicycle);
            } else {
                if (result < 0) {
                    result = currentMaterials + currentMagicLevel;
                    materialsBoxStack.pop();
                    magicLevelQueue.poll();
                    materialsBoxStack.push(result);
                } else if (result > 0) {
                    magicLevelQueue.poll();
                    currentMaterials += 15;
                    materialsBoxStack.pop();
                    materialsBoxStack.push(currentMaterials);
                }
            }
        }

        if (doll > 0 && woodenTrain > 0 || teddyBear > 0 && bicycle > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsBoxStack.isEmpty()) {
            String collect = materialsBoxStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + collect);

        }
        if (!magicLevelQueue.isEmpty()) {
            String collect = magicLevelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + collect);
        }

        craftedToys.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value);
        });
    }
}
