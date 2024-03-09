package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstCardFirstPlayer = firstPlayerCards.get(0);
            int secondCardFirstPlayer = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            
            if (firstCardFirstPlayer > secondCardFirstPlayer) {
                firstPlayerCards.add(firstCardFirstPlayer);
                firstPlayerCards.add(secondCardFirstPlayer);

            } else if (secondCardFirstPlayer > firstCardFirstPlayer) {
                secondPlayerCards.add(secondCardFirstPlayer);
                secondPlayerCards.add(firstCardFirstPlayer);
            }
        }

        if (firstPlayerCards.size() != 0) {
            System.out.printf("First player wins! Sum: %d%n", getSumCards(firstPlayerCards));
        }else if (secondPlayerCards.size() != 0) {
            System.out.printf("Second player wins! Sum: %d%n", getSumCards(secondPlayerCards));
        }
    }

    public static int getSumCards (List<Integer> sumWinnerCards) {
        int sum = 0;
        for (int cards : sumWinnerCards) {
            sum += cards;
        }
        return sum;
    }
}
