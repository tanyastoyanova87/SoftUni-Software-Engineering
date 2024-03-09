package Programming_Advanced_With_Java.L01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String arithmeticalExpression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arithmeticalExpression.length(); i++) {
            char symbol = arithmeticalExpression.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                String contents = arithmeticalExpression.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
