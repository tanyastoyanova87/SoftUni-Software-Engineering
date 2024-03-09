package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P03CardsWithPower;

public class Card {

    private CardRanks rankPower;
    private CardSuits suitPower;

    public Card(CardRanks rankPower, CardSuits suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public int getPower() {
        return suitPower.getPower() + rankPower.getPower();
    }

    public void print() {
        System.out.printf("P03CardsWithPower.Card name: %s of %s; P03CardsWithPower.Card power: %d", rankPower, suitPower, getPower());
    }
}
