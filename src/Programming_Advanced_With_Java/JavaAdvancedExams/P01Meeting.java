package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);

        Deque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femaleQueue::offer);

        int matches = 0;
        while (!malesStack.isEmpty() && !femaleQueue.isEmpty()) {
            int currentFemale = femaleQueue.peek();
            int currentMale = malesStack.peek();

            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            }
            if (currentFemale <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (currentMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (currentFemale % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }
            if (currentMale == currentFemale) {
                matches++;
                malesStack.pop();
                femaleQueue.poll();
            } else {
                currentMale -= 2;
                femaleQueue.poll();
                if (currentMale > 0) {
                    malesStack.pop();
                    malesStack.push(currentMale);
                } else {
                    if (!malesStack.isEmpty()) {
                        malesStack.pop();
                    }
                }
            }
        }
        System.out.printf("Matches: %d%n", matches);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String collect = malesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Males left: " + collect);

        }
        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String collect = femaleQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + collect);
        }
    }
}

