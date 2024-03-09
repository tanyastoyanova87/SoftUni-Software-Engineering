package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if ("A".equals(pattern)) {
            fillMatrixPatternA(matrix);

            printMatrix(matrix);
        } else if ("B".equals(pattern)) {
            fillMatrixPatternB(matrix);

            printMatrix(matrix);
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = num++;
            }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = num++;
                }
            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = num++;
            }
        }
    }
}
