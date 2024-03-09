package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int moves = 0;
        boolean unmatched = false;
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (elements.size() == 0) {
                break;
            }
            String[] commandSplit = command.split(" ");
            int firstIndex = Integer.parseInt(commandSplit[0]);
            int secondIndex = Integer.parseInt(commandSplit[1]);

            if (firstIndex < 0 || firstIndex > elements.size() - 1 || secondIndex < 0 || secondIndex > elements.size() - 1
            || firstIndex == secondIndex) {
                moves++;
                for (int i = 0; i < elements.size() / 2; i++) {
                    elements.add(elements.size() / 2, "-" + moves + "a");
                    elements.add(elements.size() / 2, "-" + moves + "a");
                    break;
                }
                System.out.println("Invalid input! Adding additional elements to the board");
                unmatched = true;

            } else if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                moves++;
                String firstElement = elements.get(firstIndex);
                String secondElement = elements.get(secondIndex);

                if (firstElement.equals(secondElement)) {
                    elements.remove(firstElement);
                    elements.remove(secondElement);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);
                }
            } else {
                moves++;
                System.out.println("Try again!");
                unmatched = true;
            }

            command = scanner.nextLine();
        }
        if (!unmatched) {
            System.out.printf("You have won in %d turns!%n", moves);
        } else {
            System.out.println("Sorry you lose :(");
            if (elements.size() > 0) {
            System.out.println(String.join(" ", elements));
            }
        }
    }
}
