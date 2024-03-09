package Programming_Fundamentals_With_Java.FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> hpHero = new LinkedHashMap<>();
        Map<String, Integer> mpHero = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String heroes = scanner.nextLine();

            String[] heroesSeparated = heroes.split(" ");
            String heroName = heroesSeparated[0];
            int hitPoints = Integer.parseInt(heroesSeparated[1]);
            int manaPoints = Integer.parseInt(heroesSeparated[2]);

            hpHero.put(heroName, hitPoints);
            mpHero.put(heroName, manaPoints);
        }

        String commands = scanner.nextLine();
        while (!commands.equals("End")) {

            String[] commandSeparated = commands.split(" - ");
            String command = commandSeparated[0];
            String heroName = commandSeparated[1];

            if (command.equals("CastSpell")) {
                int mpNeeded = Integer.parseInt(commandSeparated[2]);
                String spellName = commandSeparated[3];

                if (mpHero.get(heroName) >= mpNeeded) {
                    mpHero.put(heroName, mpHero.get(heroName) - mpNeeded);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpHero.get(heroName));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }


            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(commandSeparated[2]);
                String attacker = commandSeparated[3];

                hpHero.put(heroName, hpHero.get(heroName) - damage);

                if (hpHero.get(heroName) > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hpHero.get(heroName));
                } else {
                    hpHero.remove(heroName);
                    mpHero.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }


            } else if (command.equals("Recharge")) {
                int amount = Integer.parseInt(commandSeparated[2]);

                int currentMp = mpHero.get(heroName);
                mpHero.put(heroName, mpHero.get(heroName) + amount);

                if (mpHero.get(heroName) > 200) {
                    mpHero.put(heroName, 200);
                    System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMp);
                } else {
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                }


            } else if (command.equals("Heal")) {
                int amount = Integer.parseInt(commandSeparated[2]);

                int currentHp = hpHero.get(heroName);
                hpHero.put(heroName, hpHero.get(heroName) + amount);

                if (hpHero.get(heroName) > 100) {
                    hpHero.put(heroName, 100);
                    System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHp);
                } else {
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                }
            }

            commands = scanner.nextLine();
        }

        for (String hero : hpHero.keySet()) {
            System.out.println(hero);
            System.out.printf("  HP: %d%n", hpHero.get(hero));
            System.out.printf("  MP: %d%n", mpHero.get(hero));
        }
    }
}
