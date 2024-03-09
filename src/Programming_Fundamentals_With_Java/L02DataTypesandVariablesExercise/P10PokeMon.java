package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int pokingCount = 0;
        int originalValue = pokePower;
        while (pokePower >= distance){

            pokePower -= distance;
            pokingCount++;


            if (pokePower == originalValue / 2) {
                if (exhaustionFactor != 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(pokingCount);
    }
}
