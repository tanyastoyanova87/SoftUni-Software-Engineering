package Programming_Fundamentals_With_Java.MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {

            String[] commandSplit = command.split(" ");
            String commands = commandSplit[0];

            if (commands.equals("Loot")) {
                for (int i = 1; i < commandSplit.length; i++) {
                    String item = commandSplit[i];
                    if (!initialLoot.contains(item)) {
                        initialLoot.add(0, item);
                    }
                }
            }
            if (commands.equals("Drop")) {
                int index = Integer.parseInt(commandSplit[1]);
                if (index >= 0 && index <= initialLoot.size() - 1) {
                    String item = initialLoot.remove(index);
                    initialLoot.add(item);
                }

            } else if (commands.equals("Steal")) {
                int count = Integer.parseInt(commandSplit[1]);

                if (count >= initialLoot.size()){
                    count = initialLoot.size();
                }

                List<String> stolenItems = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    int lastIndex = initialLoot.size() - 1;
                    String item = initialLoot.remove(lastIndex);
                    stolenItems.add(item);
                }
                Collections.reverse(stolenItems);
                System.out.println(String.join(", ", stolenItems));
            }

            command = scanner.nextLine();
        }


        int sum = 0;
        int items = 0;
        for (int i = 0; i < initialLoot.size(); i++) {
            String item = initialLoot.get(i);
            sum += item.length();
            items++;

        }
        if (items > 0) {
            double averageTreasureGain = sum * 1.0 / items;
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageTreasureGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
