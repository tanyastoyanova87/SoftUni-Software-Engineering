package Programming_Fundamentals_With_Java.FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> populationTown = new LinkedHashMap<>();
        Map<String, Integer> goldTown = new LinkedHashMap<>();

        String commands = scanner.nextLine();
        while (!commands.equals("Sail")) {

            String[] separatedCommands = commands.split("\\|\\|");
            String town = separatedCommands[0];
            int population = Integer.parseInt(separatedCommands[1]);
            int gold = Integer.parseInt(separatedCommands[2]);

            if (populationTown.containsKey(town) && goldTown.containsKey(town)) {
                populationTown.put(town, populationTown.get(town) + population);
                goldTown.put(town, goldTown.get(town) + gold);
            } else {
                populationTown.put(town, population);
                goldTown.put(town, gold);
            }

            commands = scanner.nextLine();
        }

        String events = scanner.nextLine();
        while (!events.equals("End")) {

            String[] separatedCommand = events.split("=>");
            String command = separatedCommand[0];

            if (command.equals("Plunder")) {
                String town = separatedCommand[1];
                int people = Integer.parseInt(separatedCommand[2]);
                int gold = Integer.parseInt(separatedCommand[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                populationTown.put(town, populationTown.get(town) - people);
                goldTown.put(town, goldTown.get(town) - gold);

                if (populationTown.get(town) <= 0 || goldTown.get(town) <= 0) {
                    populationTown.remove(town);
                    goldTown.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }

            } else if (command.equals("Prosper")) {
                String town = separatedCommand[1];
                int gold = Integer.parseInt(separatedCommand[2]);

                if (gold <= 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    goldTown.put(town, goldTown.get(town) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, goldTown.get(town));
                }
            }

            events = scanner.nextLine();
        }

        if (!populationTown.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", populationTown.size());

            for (String town : populationTown.keySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, populationTown.get(town), goldTown.get(town));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
