package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeForSingleTaskQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(timeForSingleTaskQueue::offer);

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(tasksStack::push);

        int darthVaderDucky = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;
        
        while (!timeForSingleTaskQueue.isEmpty() && !tasksStack.isEmpty()) {
            int currentTime = timeForSingleTaskQueue.poll();
            int currentTask = tasksStack.pop();

            int result = currentTime * currentTask;
            if (result > 0 && result <= 60) {
                darthVaderDucky++;

            } else if (result > 60 && result <= 120) {
                thorDucky++;

            } else if (result > 120 && result <= 180) {
                bigBlueRubberDucky++;

            } else if (result > 180 && result <= 240) {
                smallYellowRubberDucky++;

            } else {
                currentTask -= 2;
                tasksStack.push(currentTask);
                timeForSingleTaskQueue.offer(currentTime);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", darthVaderDucky);
        System.out.printf("Thor Ducky: %d%n", thorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", bigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", smallYellowRubberDucky);
    }
}
