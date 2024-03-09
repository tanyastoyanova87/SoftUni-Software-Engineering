package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedExercises;

import java.util.*;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> chars = new TreeMap<>();

        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            chars.putIfAbsent(letter, 0);
            int num = chars.get(letter) + 1;
            chars.put(letter, num);
        }

        chars.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));

    }
}
