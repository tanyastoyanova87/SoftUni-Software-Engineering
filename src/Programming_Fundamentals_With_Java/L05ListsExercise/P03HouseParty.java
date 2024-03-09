package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = new ArrayList<>();

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= commandsCount; i++) {

            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");
            String name = commandParts[0];

            if (command.contains("not")) {
                if (guestList.contains(name)) {
                    guestList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);

                }
            } else {
                if (!guestList.contains(name)) {
                    guestList.add(name);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            }
        }
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}
