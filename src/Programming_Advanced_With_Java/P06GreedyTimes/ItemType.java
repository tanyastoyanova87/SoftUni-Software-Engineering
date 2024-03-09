package Programming_Advanced_With_Java.P06GreedyTimes;

public enum ItemType {
    Cash,
    Gem,
    Gold;

    static ItemType getItemType(String name) {
        ItemType itemType = null;

        if (name.length() == 3) {
            itemType = ItemType.valueOf("Cash");
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = ItemType.valueOf("Gem");
        } else if (name.toLowerCase().equals("gold")) {
            itemType = ItemType.valueOf("Gold");
        }
        return itemType;
    }
}
