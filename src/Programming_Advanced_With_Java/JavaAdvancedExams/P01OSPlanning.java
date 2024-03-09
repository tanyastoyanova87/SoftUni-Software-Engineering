package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasksStack::push);

        Deque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int threadThatKilledTheTask = 0;
        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {
            int currentTask = tasksStack.peek();
            int currentThread = threadsQueue.peek();
            if (currentTask == taskToKill) {
                threadThatKilledTheTask = currentThread;
                break;
            }
            if (currentThread >= currentTask) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadThatKilledTheTask, taskToKill);
        threadsQueue.forEach(e -> System.out.print(e + " "));
    }
}
