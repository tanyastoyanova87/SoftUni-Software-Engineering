package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '.';
                }
            }
        }

        int flowers = 0;
        boolean lost = false;
        while (true) {
            String command = scanner.nextLine();
            if ("End".equals(command)) {
                break;
            }

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
                lost = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == 'f') {
                matrix[rowMatrix][colMatrix] = '.';
                flowers++;
            } else if (matrix[rowMatrix][colMatrix] == 'O') {
                matrix[rowMatrix][colMatrix] = '.';
                switch (command) {
                    case "up":
                        rowMatrix--;
                        if (matrix[rowMatrix][colMatrix] == 'f') {
                            matrix[rowMatrix][colMatrix] = '.';
                            flowers++;
                        }
                        matrix[rowMatrix][colMatrix] = '.';
                        break;
                    case "down":
                        rowMatrix++;
                        if (matrix[rowMatrix][colMatrix] == 'f') {
                            matrix[rowMatrix][colMatrix] = '.';
                            flowers++;
                        }
                        matrix[rowMatrix][colMatrix] = '.';
                        break;
                    case "right":
                        colMatrix++;
                        if (matrix[rowMatrix][colMatrix] == 'f') {
                            matrix[rowMatrix][colMatrix] = '.';
                            flowers++;
                        }
                        matrix[rowMatrix][colMatrix] = '.';
                        break;
                    case "left":
                        colMatrix--;
                        if (matrix[rowMatrix][colMatrix] == 'f') {
                            matrix[rowMatrix][colMatrix] = '.';
                            flowers++;
                        }
                        matrix[rowMatrix][colMatrix] = '.';
                        break;
                }
            }
        }

        if (!lost && flowers >= 5) {
            matrix[rowMatrix][colMatrix] = 'B';
        } else if (!lost && flowers < 5) {
            matrix[rowMatrix][colMatrix] = 'B';

        }
        if (lost) {
            System.out.println("The bee got lost!");
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
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
