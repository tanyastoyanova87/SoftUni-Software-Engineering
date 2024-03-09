package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '.';
                }
            }
        }

        boolean finished = false;
        for (int command = 0; command < commands; command++) {
            String command1 = scanner.nextLine();

            switch (command1) {
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
            if ((rowMatrix < 0 || rowMatrix > matrix.length - 1) || (colMatrix < 0 || colMatrix > matrix[0].length - 1)) {
                if (rowMatrix < 0) {
                    rowMatrix = matrix.length - 1;
                }
                if (rowMatrix > matrix.length - 1) {
                    rowMatrix = 0;
                }
                if (colMatrix < 0) {
                    colMatrix = matrix[0].length - 1;
                }
                if (colMatrix > matrix[0].length - 1) {
                    colMatrix = 0;
                }
            }

            if (matrix[rowMatrix][colMatrix] == 'B') {
                switch (command1) {
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
                switch (command1) {
                    case "up":
                        rowMatrix++;
                        break;
                    case "down":
                        rowMatrix--;
                        break;
                    case "right":
                        colMatrix--;
                        break;
                    case "left":
                        colMatrix++;
                        break;
                }
            } else if (matrix[rowMatrix][colMatrix] == 'F') {
                finished = true;
                break;
            }
        }

        if (finished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        matrix[rowMatrix][colMatrix] = 'P';
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
