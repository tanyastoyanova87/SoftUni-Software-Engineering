package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> wormsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(wormsStack::push);

        Deque<Integer> holesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(holesQueue::offer);

        int matches = 0;
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            int currentWorm = wormsStack.peek();
            int currentHole = holesQueue.peek();

            if (currentWorm <= 0) {
                wormsStack.pop();
                continue;
            }
            if (currentWorm == currentHole) {
                matches++;
                wormsStack.pop();
                holesQueue.poll();
            } else {
                holesQueue.poll();
                currentWorm -= 3;
                wormsStack.pop();
                if (currentWorm > 0) {
                    wormsStack.push(currentWorm);
                }
            }
        }

        if (matches > 0) {
            System.out.printf("Matches: %d%n", matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (wormsStack.isEmpty() && holesQueue.isEmpty()) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            System.out.println("Worms left: none");
        } else if (!wormsStack.isEmpty()) {
            Deque<Integer> wormsQueue = new ArrayDeque<>();
            for (Integer worm : wormsStack) {
                wormsQueue.offer(worm);
                wormsStack.pop();
            }
            for (Integer worm : wormsQueue) {
                wormsStack.push(worm);
            }
            String collect = wormsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Worms left: " + collect);
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            //Deque<Integer> holeStack = new ArrayDeque<>();
            //            for (Integer worm : holesQueue) {
            //                holeStack.push(worm);
            //                holesQueue.poll();
            //            }
            //            for (Integer worm : holeStack) {
            //                holesQueue.offer(worm);
            //            }
            String collect = holesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Holes left: " + collect);
        }
    }
}
