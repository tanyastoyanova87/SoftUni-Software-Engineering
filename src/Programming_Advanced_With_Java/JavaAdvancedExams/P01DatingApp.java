package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);

        Deque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int currentMale = malesStack.peek();
            int currentFemale = femalesQueue.peek();
            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            }
            if (currentFemale <= 0) {
                femalesQueue.poll();
                continue;
            }

            if (currentMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (currentFemale % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (currentMale == currentFemale) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                currentMale -= 2;
                malesStack.pop();
                malesStack.push(currentMale);
            }
        }

        System.out.printf("Matches: %d%n", matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            List<String> malesLeft = new ArrayList<>();
            malesStack.forEach(e -> malesLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", malesLeft));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            List<String> femalesLeft = new ArrayList<>();
            femalesQueue.forEach(e -> femalesLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", femalesLeft));
        }
    }
}
