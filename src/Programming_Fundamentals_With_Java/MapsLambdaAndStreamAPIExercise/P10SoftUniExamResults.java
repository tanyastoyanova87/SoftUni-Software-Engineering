package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> exams = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languageCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] inputCommands = input.split("-");
            String username = inputCommands[0];
            String language = inputCommands[1];

            if (input.contains("banned")) {
                exams.remove(username);
                break;
            }

            if (inputCommands.length == 3) {
            int points = Integer.parseInt(input.split("-")[2]);
                if (!exams.containsKey(username)) {
                    exams.put(username, points);
                } else {
                    int currentPoints = exams.get(username);
                    if (points > currentPoints) {
                        exams.put(username, points);
                    }
                }
            }


            if (!languageCount.containsKey(language)) {
                languageCount.put(language, 1);
            } else {
                languageCount.put(language, languageCount.get(language) + 1);
            }

            input = scanner.nextLine();

        }

        System.out.println("Results:");
        exams.entrySet().forEach(entry -> System.out.printf("%s | %d%n", entry.getKey(), entry.getValue()));

        System.out.println("Submissions:");
        languageCount.entrySet().forEach(language -> System.out.printf("%s - %d%n", language.getKey(), language.getValue()));

    }
}
