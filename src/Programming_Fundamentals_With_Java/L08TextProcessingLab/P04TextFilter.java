package Programming_Fundamentals_With_Java.L08TextProcessingLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            String replacement = generateReplacement(word);
            text = text.replace(word, replacement);
        }

        System.out.println(text);
    }

    private static String generateReplacement(String word) {
        char[] replacementCharArray = new char[word.length()];

        Arrays.fill(replacementCharArray, '*');

        return new String(replacementCharArray);
    }
}
