package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, matrix);

        int rowMatrix = 0;
        int colMatrix = 0;
        int firstBarrowRow = 0;
        int firstBarrowCol = 0;
        int secondBarrowRow = 0;
        int secondBarrowCol = 0;
        boolean firstFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '.';
                }
                
                if (matrix[row][col] == 'B' && !firstFound) {
                    firstFound = true;
                    firstBarrowRow = row;
                    firstBarrowCol = col;
                }

                if (matrix[row][col] == 'B' && firstFound) {
                    secondBarrowRow = row;
                    secondBarrowCol = col;
                }
            }
        }

        int food = 0;
        boolean out = false;

        while (food < 10) {

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

            if (matrix[rowMatrix][colMatrix] == '*') {
                food++;
                matrix[rowMatrix][colMatrix] = '.';
            } else if (matrix[rowMatrix][colMatrix] == 'B') {
                matrix[rowMatrix][colMatrix] = '.';
                rowMatrix = secondBarrowRow;
                colMatrix = secondBarrowCol;
                matrix[rowMatrix][colMatrix] = '.';
            } else {
                matrix[rowMatrix][colMatrix] = '.';
            }
        }

        if (out) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("P04WildFarm.P04WildFarm.Food eaten: %d%n", food);

        if (!out) {
            matrix[rowMatrix][colMatrix] = 'S';
            printMatrix(matrix);
        } else {
            printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
