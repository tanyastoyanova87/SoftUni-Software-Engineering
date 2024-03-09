package Programming_Advanced_With_Java.L01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {

            if (!"back".equals(command) && !"forward".equals(command)) {
                stack.push(command);
                queue.offer(command);
                System.out.println(command);

            } else if ("forward".equals(command)) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    queue.poll();
                    System.out.println(queue.peek());
                }
            } else {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }

            }

            command = scanner.nextLine();
        }
    }
}
