package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);

        int totalStrength = 0;

        for (int i = 0; i < text.length(); i++) {

            char currentSymbol = text.charAt(i);
            if (currentSymbol == '>') {
                int explosionStrength = Integer.parseInt(text.charAt(i + 1) + "");
                totalStrength += explosionStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                text.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }

        System.out.println(text);
    }
}
