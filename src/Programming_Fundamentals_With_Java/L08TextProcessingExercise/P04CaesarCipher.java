package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            char replacedSymbol = (char) (symbol + 3);
            result.append(replacedSymbol);
        }

        System.out.println(result);
    }
}
