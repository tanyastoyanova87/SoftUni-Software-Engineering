package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipStatus = Arrays.stream(scanner.nextLine()
                        .split(">")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warshipStatus = Arrays.stream(scanner.nextLine()
                        .split(">")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Retire")) {

            String[] commandSplit = command.split(" ");
            String action = commandSplit[0];

            if (action.equals("Fire")) {
                int index = Integer.parseInt(commandSplit[1]);
                int damage = Integer.parseInt(commandSplit[2]);

                if (index >= 0 && index < warshipStatus.size()) {
                    warshipStatus.set(index, warshipStatus.get(index) - damage);
                    if (warshipStatus.get(index) <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }

            } else if (action.equals("Defend")) {
                int startIndex = Integer.parseInt(commandSplit[1]);
                int endIndex = Integer.parseInt(commandSplit[2]);
                int damage = Integer.parseInt(commandSplit[3]);

                if (startIndex >= 0 && startIndex < pirateShipStatus.size() && endIndex >= 0 && endIndex < pirateShipStatus.size()) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShipStatus.set(i, pirateShipStatus.get(i) - damage);
                        if (pirateShipStatus.get(i) <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }

            } else if (action.equals("Repair")) {
                int index = Integer.parseInt(commandSplit[1]);
                int health = Integer.parseInt(commandSplit[2]);

                if (index >= 0 && index < pirateShipStatus.size()) {
                    int indexList = pirateShipStatus.get(index);
                    int healthInSection = indexList + health;
                    if (healthInSection <= maxHealthCapacity) {
                        pirateShipStatus.remove(index);
                        pirateShipStatus.add(index, healthInSection);
                    } else {
                        pirateShipStatus.set(index, maxHealthCapacity);
                    }
                }
            } else if (action.equals("Status")) {
                int countSectionsRepair = 0;
                for (int i = 0; i < pirateShipStatus.size(); i++) {
                    int currentSection = pirateShipStatus.get(i);
                    if (currentSection < 0.20 * maxHealthCapacity) {
                        countSectionsRepair++;
                    }
                }
                System.out.printf("%d sections need repair.%n", countSectionsRepair);
            }
            command = scanner.nextLine();
        }
        int sumPirateShip = 0;
        for (int section : pirateShipStatus) {
            sumPirateShip += section;
        }
        System.out.printf("Pirate ship status: %d%n", sumPirateShip);

        int sumWarship = 0;
        for (int section : warshipStatus) {
            sumWarship += section;
        }
        System.out.printf("Warship status: %d%n", sumWarship);

    }
}
