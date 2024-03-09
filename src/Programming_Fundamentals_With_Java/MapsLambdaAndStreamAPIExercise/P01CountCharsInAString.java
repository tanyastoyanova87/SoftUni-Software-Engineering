package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

        String word = scanner.nextLine();
        for (Character character : word.toCharArray()) {
            if (character.equals(' ')){
                continue;
            }
            if (count.containsKey(character)) {
                count.put(character, count.get(character) + 1);
            } else {
                count.put(character, 1);
            }
        }

        for (Map.Entry<Character, Integer> kvp : count.entrySet()) {
            System.out.printf("%c -> %d%n", kvp.getKey(), kvp.getValue());
        }

        //count.entrySet().forEach(entry -> System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue()));
    }
}
