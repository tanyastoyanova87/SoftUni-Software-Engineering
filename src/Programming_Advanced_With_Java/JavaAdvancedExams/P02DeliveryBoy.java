package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int initialRow = 0;
        int initialCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'B') {
                    rowMatrix = row;
                    colMatrix = col;
                    initialRow = row;
                    initialCol = col;
                }
            }
        }

        String direction;
        boolean out = false;
        while (true) {

            direction = scanner.nextLine();

            switch (direction) {
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

            if (rowMatrix < 0 || rowMatrix >= rows || colMatrix < 0 ||colMatrix >= cols) {
                out = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == '*') {
                switch (direction) {
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
            }


            if (matrix[rowMatrix][colMatrix] == 'P') {
                System.out.println("P04PizzaCalories.Pizza is collected. 10 minutes for delivery.");
                matrix[rowMatrix][colMatrix] = 'R';
            } else if (matrix[rowMatrix][colMatrix] == '-') {
                matrix[rowMatrix][colMatrix] = '.';
            } else if (matrix[rowMatrix][colMatrix] == 'A') {
                matrix[rowMatrix][colMatrix] = 'P';
                System.out.println("P04PizzaCalories.Pizza is delivered on time! Next order...");
                break;

            }
        }

        if (out) {
            matrix[initialRow][initialCol] = ' ';
            System.out.println("The delivery is late. Order is canceled.");
            printMatrix(matrix, rows, cols);
        } else {
            printMatrix(matrix, rows, cols);
        }
    }

    private static void printMatrix(char[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
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
