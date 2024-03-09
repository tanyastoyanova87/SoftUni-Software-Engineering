package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        boolean firstFound = false;
        int firstPillarRow = 0;
        int firstPillarCol = 0;
        int secondPillarRow = 0;
        int secondPillarCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }

                if (matrix[row][col] == 'P' && !firstFound) {
                    firstFound = true;
                    firstPillarRow = row;
                    firstPillarCol = col;
                }

                if (matrix[row][col] == 'P' && firstFound) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }

        int money = 0;
        boolean out = false;
        while (money < 50) {
            String command = scanner.nextLine();

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

            if (rowMatrix < 0 || rowMatrix >= size || colMatrix < 0 || colMatrix >= size) {
                out = true;
                break;
            }

            if (Character.isDigit(matrix[rowMatrix][colMatrix])) {
                char symbol = matrix[rowMatrix][colMatrix];
                int numericValue = Character.getNumericValue(symbol);
                money += numericValue;
                matrix[rowMatrix][colMatrix] = '-';
            } else if (matrix[rowMatrix][colMatrix] == 'P') {
                matrix[rowMatrix][colMatrix] = '-';
                rowMatrix = secondPillarRow;
                colMatrix = secondPillarCol;
                matrix[secondPillarRow][secondPillarCol] = '-';
            }
        }

        if (out) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            matrix[rowMatrix][colMatrix] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);
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
