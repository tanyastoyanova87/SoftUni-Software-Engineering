package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = input.length() - 1; i >= 0; i--) {
            char symbol = input.charAt(i);
            System.out.print(symbol);
        }
    }
}
