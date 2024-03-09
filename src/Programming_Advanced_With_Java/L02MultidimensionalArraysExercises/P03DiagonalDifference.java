package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        readMatrix(matrix, scanner);

        int sumFirstDiagonal = getSumFirstDiagonal(matrix);

        int sumSecondDiagonal = getSumSecondDiagonal(matrix);

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }

    private static int getSumSecondDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[matrix.length - 1 - row][row];
        }

        return sum;
    }

    private static int getSumFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
