package Programming_Fundamentals_With_Java.L04MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            System.out.println(checkIfIsPalindrome(command));
            command = scanner.nextLine();
        }
    }

    public static boolean checkIfIsPalindrome (String text) {
        String reversedText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedText += text.charAt(i);
        }
        return text.equals(reversedText);
    }
}
