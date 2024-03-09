package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P02CardRank;

public enum CardRanks {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public static void printCards() {
        System.out.println("P03CardsWithPower.Card Ranks:");
        for (CardRanks value : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }
    }
}