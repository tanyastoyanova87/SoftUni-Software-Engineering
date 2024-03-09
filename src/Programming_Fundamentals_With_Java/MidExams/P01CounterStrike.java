package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        boolean gameOver = false;
        int wins = 0;
        String command = scanner.nextLine();
        while (!command.equals("End of battle")) {

            int distance = Integer.parseInt(command);
            if (initialEnergy >= distance) {
                initialEnergy -= distance;
                wins++;
                if (wins % 3 == 0) {
                    initialEnergy += wins;
                }
            } else {
                gameOver = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (gameOver) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wins, initialEnergy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d%n", wins, initialEnergy);
        }
    }
}
