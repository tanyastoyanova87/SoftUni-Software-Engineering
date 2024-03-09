package Programming_Fundamentals_With_Java.L02DataTypesandVariablesLab;

import java.util.Scanner;

public class P04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        long population = scanner.nextLong();
        short area = scanner.nextShort();

        System.out.printf("Town %s has population of %d and area %d square km.%n", town, population, area);
    }
}
