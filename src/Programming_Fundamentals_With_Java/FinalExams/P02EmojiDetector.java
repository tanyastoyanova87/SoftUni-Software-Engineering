package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int coolThreshold = getThreshold(input);
        System.out.printf("Cool threshold: %d%n", coolThreshold);

        List<String> emojis = getEmojis(input);

        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojis.size());

        for (String emoji : emojis) {
            int coolness = 0;
            for (char symbol : emoji.toCharArray()) {
                if (Character.isLetter(symbol))
                    coolness += symbol;
            }

            if (coolness >= coolThreshold) {
                System.out.println(emoji);
            }
        }

    }

    private static List<String> getEmojis(String input) {
        Pattern pattern = Pattern.compile("(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> emojis = new ArrayList<>();
        while (matcher.find()) {
            emojis.add(matcher.group());
        }

        return emojis;
    }

    private static int getThreshold(String input) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);

        int result = 1;
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());
            result *= digit;
        }

        return result;
    }
}
