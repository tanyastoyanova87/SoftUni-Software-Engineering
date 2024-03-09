package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<food>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> foodInfo = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {

            String food = matcher.group("food");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;

            String foodOutput = String.format("Item: %s, Best before: %s, Nutrition: %d", food, expirationDate, calories);
            foodInfo.add(foodOutput);
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        foodInfo.forEach(System.out::println);
    }
}
