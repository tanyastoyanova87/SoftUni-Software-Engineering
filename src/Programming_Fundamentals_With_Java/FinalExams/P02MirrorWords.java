package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[a-zA-Z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> matches = new ArrayList<>();

        int validPairs = 0;
        while (matcher.find()) {
            validPairs++;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");

            StringBuilder secondWordBuilder = new StringBuilder(secondWord).reverse();

            if (firstWord.equals(secondWordBuilder.toString())) {
                matches.add(String.join(" <=> ", firstWord, secondWord));
            }
        }

        if (validPairs > 0) {
            System.out.printf("%d word pairs found!%n", validPairs);
        } else {
            System.out.println("No word pairs found!");
        }

        if (matches.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", matches));

        }
    }
}
