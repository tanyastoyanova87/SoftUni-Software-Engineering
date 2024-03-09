package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Map;
import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String[] texts = text.split(" ");
        String firstText = texts[0];
        String secondText = texts[1];

        getSum(firstText, secondText);

    }

    public static void getSum (String firstText, String secondText) {
        int maxLength = Math.max(firstText.length(), secondText.length());
        int minLength = Math.min(firstText.length(), secondText.length());

        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            sum += firstText.charAt(i) * secondText.charAt(i);
        }

        if (firstText.length() == secondText.length()) {
            System.out.println(sum);
        }
        else if (maxLength == firstText.length()){
            for (int i = minLength; i < firstText.length(); i++) {
                sum += firstText.charAt(i);
            }
                System.out.println(sum);

        } else {
            for (int i = minLength; i < secondText.length(); i++) {
                sum += secondText.charAt(i);
            }
                System.out.println(sum);
        }

    }
}
