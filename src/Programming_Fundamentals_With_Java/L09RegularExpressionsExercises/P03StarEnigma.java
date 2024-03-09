package Programming_Fundamentals_With_Java.L09RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<planetPopulation>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldierCount>[0-9]+)");

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {

            String encryptMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }

        }
            System.out.println("Attacked planets: " + attackedPlanets.size());
            Collections.sort(attackedPlanets);
            attackedPlanets.forEach(planet -> System.out.println("-> " + planet));

            System.out.println("Destroyed planets: " + destroyedPlanets.size());
            Collections.sort(destroyedPlanets);
            destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecryptedMessage(String encryptMessage) {
        int countLetters = getSpecialLettersCount(encryptMessage);
        StringBuilder decryptedMessage = new StringBuilder();

        for (char symbol : encryptMessage.toCharArray()) {
            char newSymbol = (char) (symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLettersCount(String encryptMessage) {
        int count = 0;

        for (char symbol : encryptMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }
        return count;
    }
}
