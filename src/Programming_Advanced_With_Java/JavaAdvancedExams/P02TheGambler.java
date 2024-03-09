package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'G') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        String command = scanner.nextLine();
        int money = 100;
        boolean wonJackpot = false;
        while (!"end".equals(command)) {

            switch (command) {
                case "up":
                    rowMatrix--;
                    break;
                case "down":
                    rowMatrix++;
                    break;
                case "right":
                    colMatrix++;
                    break;
                case "left":
                    colMatrix--;
                    break;
            }


            if (matrix[rowMatrix][colMatrix] == 'W') {
                money += 100;
                matrix[rowMatrix][colMatrix] = '-';
            } else if (matrix[rowMatrix][colMatrix] == 'P') {
                money -= 200;
                matrix[rowMatrix][colMatrix] = '-';
            } else if (matrix[rowMatrix][colMatrix] == 'J') {
                money += 100000;
                wonJackpot = true;
                matrix[rowMatrix][colMatrix] = '-';
                break;
            }

            if (rowMatrix < 0 && rowMatrix >= size && colMatrix < 0 && colMatrix >= size) {
                System.out.println("Game over! You lost everything!");
                return;
            }

            if (money <= 0) {
                System.out.println("Game over! You lost everything!");
                return;
            }

            command = scanner.nextLine();
        }

        matrix[rowMatrix][colMatrix] = 'G';

        if (wonJackpot) {
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$%n", money);
        } else {
            System.out.printf("End of the game. Total amount: %d$%n", money);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
