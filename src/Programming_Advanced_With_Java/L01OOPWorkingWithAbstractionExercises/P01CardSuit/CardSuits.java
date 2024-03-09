package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P01CardSuit;

public enum CardSuits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static void printCardSuits() {
        System.out.println("P03CardsWithPower.Card P01CardSuit.Suits:");
        for (CardSuits value : CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }
    }
}
