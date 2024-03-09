package Programming_Advanced_With_Java.L01StacksAndQueuesExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                             .collect(Collectors.toList());

        String result = isBalanced(input) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean isBalanced(List<String> input) {
        Deque<String> openParenthesesStack = new ArrayDeque<>();

        for (String brace : input) {

            switch (brace) {
                case ")":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    String openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("(")) {
                        return false;
                    }
                    break;
                case "]":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("[")) {
                        return false;
                    }
                    break;
                case "}":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("{")) {
                        return false;
                    }
                    break;
                default:
                    openParenthesesStack.push(brace);
                    break;
            }
        }

        return openParenthesesStack.isEmpty();
    }
}
