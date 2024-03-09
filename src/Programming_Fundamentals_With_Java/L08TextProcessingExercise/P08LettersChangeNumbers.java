package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (String text : input) {
            double modifiedNumber = getModifiedNumber(text);
            sum += modifiedNumber;
        }

        System.out.printf("%.2f%n", sum);
    }

    private static double getModifiedNumber(String text) {
        char letterBefore = text.charAt(0);
        char letterAfter = text.charAt(text.length() - 1);
        double num = Double.parseDouble(text.replace(letterBefore, ' ')
                                             .replace(letterAfter, ' ').trim());

        if (Character.isUpperCase(letterBefore)) {
            int position = (int) letterBefore - 64;
            num /= position;
        } else if (Character.isLowerCase(letterBefore)) {
            int position = (int) letterBefore - 96;
            num *= position;
        }

        if (Character.isUpperCase(letterAfter)) {
            int position = (int) letterAfter - 64;
            num -= position;
        } else if (Character.isLowerCase(letterAfter)) {
            int position = (int) letterAfter - 96;
            num += position;
        }

        return num;
    }
}
