package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRanks cardRanks = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardRanks, cardSuits);

        card.print();
    }
}
