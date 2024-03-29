package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Craft!")) {

            String[] commandSplit = command.split(" - ");
            String action = commandSplit[0];
            String item = commandSplit[1];

            if (action.equals("Collect")) {
                if (!journal.contains(item)) {
                    journal.add(item);
                }
            } else if (action.equals("Drop")) {
                if (journal.contains(item)) {
                    journal.remove(item);
                }

            } else if (action.equals("Combine Items")) {
                String oldItem = item.split(":")[0];
                String newItem = item.split(":")[1];
                if (journal.contains(oldItem)) {
                    journal.add(journal.indexOf(oldItem) + 1, newItem);
                }

            } else if (action.equals("Renew")) {
                if (journal.contains(item)) {
                    journal.remove(item);
                    journal.add(item);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", journal));
    }
}
