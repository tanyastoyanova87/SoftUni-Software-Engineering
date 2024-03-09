package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int firstMirrorRow = 0;
        int firstMirrorCol = 0;
        int secondMirrorRow = 0;
        int secondMirrorCol = 0;
        boolean firstFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'A') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }

                if (matrix[row][col] == 'M' && !firstFound) {
                    firstFound = true;
                    firstMirrorRow = row;
                    firstMirrorCol = col;
                }

                if (matrix[row][col] == 'M' && firstFound) {
                    secondMirrorRow = row;
                    secondMirrorCol = col;
                }
            }
        }

        int goldCoins = 0;
        boolean out = false;
        while (goldCoins < 65) {
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
                int digit = matrix[rowMatrix][colMatrix];
                int numericValue = Character.getNumericValue(digit);
                goldCoins += numericValue;
                matrix[rowMatrix][colMatrix] = '-';

            } else if (matrix[rowMatrix][colMatrix] == 'M') {
                matrix[rowMatrix][colMatrix] = '-';
                rowMatrix = secondMirrorRow;
                colMatrix = secondMirrorCol;
                matrix[rowMatrix][colMatrix] = '-';
            }
        }

        if (out) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", goldCoins);

        if (out) {
            printMatrix(matrix);
        } else {
            matrix[rowMatrix][colMatrix] = 'A';
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

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
