package Programming_Fundamentals_With_Java.L08TextProcessingLab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        while (!text.equals("end")) {

            String reversedWord = reversedWord(text);

            System.out.printf("%s = %s%n", text, reversedWord);

            text = scanner.nextLine();
        }
    }

    private static String reversedWord(String text) {
        char[] reversedResult = new char[text.length()];

        int reversedResultIndex = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            char currentChar = text.charAt(i);
            reversedResult[reversedResultIndex] = currentChar;
            reversedResultIndex += 1;
        }
        return new String(reversedResult);
    }
}
