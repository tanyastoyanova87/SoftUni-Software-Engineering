package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                }
            }
        }
        matrix[rowMatrix][colMatrix] = '-';

        boolean sinks = false;
        int tons = 0;
        String command = scanner.nextLine();
        while (!"collect the nets".equals(command)) {

            switch (command) {
                case "up":
                    rowMatrix--;
                    break;
                case "down":
                    rowMatrix++;
                    break;
                case "left":
                    colMatrix--;
                    break;
                case "right":
                    colMatrix++;
                    break;
            }

            if (rowMatrix < 0 || rowMatrix >= size) {
                if (rowMatrix < 0) {
                    rowMatrix = size - 1;
                }
                if (rowMatrix >= size) {
                    rowMatrix = 0;
                }
            }

            if (colMatrix < 0 || colMatrix >= size) {
                if (colMatrix < 0) {
                    colMatrix = size - 1;
                }
                if (colMatrix >= size) {
                    colMatrix = 0;
                }
            }


            if (Character.isDigit(matrix[rowMatrix][colMatrix])) {
                char digitChar = matrix[rowMatrix][colMatrix];
                int numericValue = Character.getNumericValue(digitChar);
                tons += numericValue;
                matrix[rowMatrix][colMatrix] = '-';
            } else if (matrix[rowMatrix][colMatrix] == 'W') {
                sinks = true;
                break;
            }

            command = scanner.nextLine();
        }
        matrix[rowMatrix][colMatrix] = 'S';

        if (sinks) {
            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught." +
                    " Last coordinates of the ship: [%d,%d]", rowMatrix, colMatrix);

        } else {
            if (tons >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - tons);
            }

            if (tons > 0) {
                System.out.printf("Amount of fish caught: %d tons.%n", tons);
            }
            if (!sinks) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix.length; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
            }

        }

    }
}
