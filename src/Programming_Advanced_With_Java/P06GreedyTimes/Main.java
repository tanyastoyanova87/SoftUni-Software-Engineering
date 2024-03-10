package Programming_Advanced_With_Java.P06GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            ItemType itemType = ItemType.getItemType(name);
            Item item = new Item(itemType, name, amount);
            bag.add(item);
        }

        bag.printItems();
    }
}
