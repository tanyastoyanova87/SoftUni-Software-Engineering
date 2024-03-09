package Programming_Fundamentals_With_Java.L09RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().replaceAll(" ", "").split(",");

        for (String demon : demonNames) {
            int health = getHealth(demon);
            double damage = getDamage(demon);

            for (char symbol : demon.toCharArray()) {
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }

    private static double getDamage(String demon) {
        double damage = 0;
        Pattern pattern = Pattern.compile("[-]?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(demon);

        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }
        return  damage;
    }

    private static int getHealth(String demon) {
        int health = 0;
        Pattern pattern = Pattern.compile("[^0-9+\\-*/.]");
        Matcher matcher = pattern.matcher(demon);

        while (matcher.find()) {
            health += matcher.group().charAt(0);
        }
        return health;
    }
}
