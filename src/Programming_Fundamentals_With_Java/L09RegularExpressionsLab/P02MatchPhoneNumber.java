package Programming_Fundamentals_With_Java.L09RegularExpressionsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}\\b");
        Matcher matcher = pattern.matcher(input);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {

            result.add(matcher.group());
        }
        System.out.println(String.join(", ", result));
    }
}
