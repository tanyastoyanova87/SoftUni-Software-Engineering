package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        for (int col = cols - 1; col > 0 ; col--) {
            for (int row = rows - 1, c = col; row >= 0 && c < cols; row--, c++) {
                System.out.print(matrix[row][c] + " ");
            }
            System.out.println();
        }

        for (int row = rows - 1; row >= 0 ; row--) {
            for (int r = row, col = 0; r >= 0 && col < cols; r--, col++) {
                System.out.print(matrix[r][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
