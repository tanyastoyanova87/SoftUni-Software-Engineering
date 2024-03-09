package Programming_Advanced_With_Java.P06GreedyTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void printItems(Bag bag) {
        for (Item item : bag.getItems()) {
            System.out.printf("<%s> $%d%n", item.getItemType(), item.getAmount());
            items.stream().map(Item::getName).forEach(p -> {
                System.out.printf("##%s %d%n", item.getName(), item.getAmount());
            });
        }
    }
}
