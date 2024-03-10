package Programming_Advanced_With_Java.P06GreedyTimes;

import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void add(Item item) {
        if (canAdd(item)) {
            this.items.add(item);
        }
    }

    private boolean canAdd(Item item) {
        if (this.capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }
        if (item.getItemType() == null) {
            return false;
        }

        switch (item.getItemType()) {
            case Gem:
                if (item.getAmount() + getTotalAmountByType(ItemType.Gem) >
                        getTotalAmountByType(ItemType.Gold)) {
                    return false;
                }
                break;
            case Cash:
                if (item.getAmount() + getTotalAmountByType(ItemType.Cash) >
                        getTotalAmountByType(ItemType.Gem)) {
                    return false;
                }
                break;
        }
        return true;
    }


    private long getTotalAmountByType(ItemType itemType) {
        return this.items
                .stream()
                .filter(i -> i.getItemType().equals(itemType))
                .mapToLong(Item::getAmount)
                .sum();
    }

    private long getTotalAmount() {
        return this.items
                .stream()
                .mapToLong(Item::getAmount)
                .sum();
    }

    public void printItems() {
        Map<String, Long> totalAmountsByType = new LinkedHashMap<>();
        for (Item item : items) {
            String itemType = String.valueOf(item.getItemType());
            long totalAmount = totalAmountsByType.getOrDefault(itemType, 0L) + item.getAmount();
            totalAmountsByType.put(itemType, totalAmount);
        }

        totalAmountsByType.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(entry -> {
                    String itemType = entry.getKey();
                    long totalAmount = entry.getValue();
                    System.out.printf("<%s> $%d%n", itemType, totalAmount);

                    List<Item> filteredItems = items.stream()
                            .filter(item -> item.getItemType().toString().equals(itemType))
                            .sorted(
                                    Comparator.comparing(Item::getName).reversed()
                                            .thenComparing(Item::getAmount)
                            )
                            .collect(Collectors.toList());

                    filteredItems.forEach(item -> System.out.printf("##%s - %d%n", item.getName(), item.getAmount()));
                });
    }
}
//for (Programming_Advanced_With_Java.P06GreedyTimes.Item item : bag.getItems()) {
//            System.out.printf("<%s> $%d%n", item.getItemType(), item.getAmount());
//                System.out.printf("##%s - %d%n", item.getName(), item.getAmount());
//            };
//        }

