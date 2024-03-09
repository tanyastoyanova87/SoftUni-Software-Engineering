package Programming_Advanced_With_Java.L01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack =  new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {

            if (!"back".equals(command)) {
                stack.push(command);
                System.out.println(command);
            } else {
                if (stack.size() <= 1) {
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
