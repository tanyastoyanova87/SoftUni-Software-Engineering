package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\|");

        boolean isAlive = true;
        int health = 100;
        int totalBitcoins = 0;
        for (int i = 0; i < text.length; i++) {
            String currentText = text[i];
            String[] currentTextSplit = currentText.split(" ");
            String command = currentTextSplit[0];
            int num = Integer.parseInt(currentTextSplit[1]);

            int bitcoins = 0;
            if (command.equals("potion")) {
                int healthBeforeHealing = health;
                health += num;
                if (health > 100) {
                    health = 100;
                }
                System.out.printf("You healed for %d hp.%n", health - healthBeforeHealing);
                System.out.printf("Current health: %d hp.%n", health);

            } else if (command.equals("chest")) {
                bitcoins += num;
                totalBitcoins += bitcoins;
                System.out.printf("You found %d bitcoins.%n", num);

            } else {
                health -= num;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", i + 1);
                    isAlive = false;
                    break;
                }
            }
        }
        if (isAlive) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", totalBitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
