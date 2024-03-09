package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();
        List<String> destinations = new ArrayList<>();

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);

        int totalLength = 0;
        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
            int destinationLength = matcher.group("destination").length();
            totalLength += destinationLength;
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinations));
        System.out.printf("Travel Points: %d%n", totalLength);
    }
}
