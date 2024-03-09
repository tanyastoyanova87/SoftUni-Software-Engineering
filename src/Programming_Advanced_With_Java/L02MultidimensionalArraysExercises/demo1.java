package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine()
                        .split(", ")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, rows, scanner);

        System.out.println(rows);
        System.out.println(cols);
        sumElements(rows, cols, matrix);
    }

    private static void sumElements(int rows, int cols, int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, int rows, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                            .split(", ")).mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }
    }
}
