package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> licensePlatesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(licensePlatesQueue::offer);

        Deque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(carsStack::push);

        int registeredCars = 0;
        int daysCount = 0;
        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            int currentLicencePlates = licensePlatesQueue.poll();
            int currentCars = carsStack.pop();
            daysCount++;

            int neededPlates = 2 * currentCars;
            if (neededPlates == currentLicencePlates) {
                registeredCars += currentCars;

            } else if (neededPlates > currentLicencePlates) {
                int leftCars = (neededPlates - currentLicencePlates) / 2;
                carsStack.offer(leftCars);
                registeredCars += currentCars - leftCars;

            } else {
                registeredCars += currentCars;
                currentLicencePlates -= neededPlates;
                licensePlatesQueue.offer(currentLicencePlates);
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, daysCount);

        if (!licensePlatesQueue.isEmpty()) {
            int sum = 0;
            for (Integer license : licensePlatesQueue) {
                sum += license;
            }
            System.out.printf("%d license plates remain!%n", sum);
        }

        if (!carsStack.isEmpty()) {
            int sum = 0;
            for (Integer car : carsStack) {
                sum += car;
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        }

        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
