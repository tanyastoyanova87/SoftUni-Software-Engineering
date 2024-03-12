package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'f') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        boolean won = false;
        for (int com = 0; com < countCommands; com++) {
            String command = scanner.nextLine();

            int lastRow = rowMatrix;
            int lastCol = colMatrix;

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
                switch (command) {
                    case "up":
                        rowMatrix = matrix.length - 1;
                        break;
                    case "down":
                        rowMatrix = 0;
                        break;
                    case "right":
                        colMatrix = 0;
                        break;
                    case "left":
                        colMatrix = matrix.length - 1;
                        break;
                }
            }
            if (matrix[rowMatrix][colMatrix] == 'B') {
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
            } else if (matrix[rowMatrix][colMatrix] == 'T') {
                rowMatrix = lastRow;
                colMatrix = lastCol;

            } else if (matrix[rowMatrix][colMatrix] == 'F') {
                System.out.println("Programming_Advanced_With_Java.L02OOPEncapsulationExercises.P05FootballTeamGenerator.Player won!");
                matrix[rowMatrix][colMatrix] = 'f';
                won = true;
                break;
            }

            if (rowMatrix < 0 || rowMatrix >= size || colMatrix < 0 || colMatrix >= size) {
                switch (command) {
                    case "up":
                        rowMatrix = matrix.length - 1;
                        break;
                    case "down":
                        rowMatrix = 0;
                        break;
                    case "right":
                        colMatrix = 0;
                        break;
                    case "left":
                        colMatrix = matrix.length - 1;
                        break;
                }
            }
        }

        if (!won) {
            matrix[rowMatrix][colMatrix] = 'f';
            System.out.println("Programming_Advanced_With_Java.L02OOPEncapsulationExercises.P05FootballTeamGenerator.Player lost!");
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
