package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> foodPortionsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(foodPortionsStack::push);

        Deque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(dailyStaminaQueue::offer);

        int[] peaksNumbers = {80, 90, 100, 60, 70};
        List<String> peaks = new ArrayList<>();
        peaks.add("Vihren");
        peaks.add("Kutelo");
        peaks.add("Banski Suhodol");
        peaks.add("Polezhan");
        peaks.add("Kamenitza");

        List<String> conquered = new ArrayList<>();
        int conqueredPeaks = 0;
        int index = 0;
        while (!foodPortionsStack.isEmpty() && !dailyStaminaQueue.isEmpty() && conqueredPeaks < 5) {
            int currentStaminaValue = dailyStaminaQueue.poll();
            int currentFoodValue = foodPortionsStack.pop();

            int sum = currentFoodValue + currentStaminaValue;

            if (sum >= peaksNumbers[index]) {
                conquered.add(peaks.get(0));
                peaks.remove(0);
                conqueredPeaks++;
                index++;
            }

        }
        if (peaks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (conqueredPeaks > 0) {
            System.out.println("Conquered peaks:");
            conquered.forEach(System.out::println);
        }
    }
}
