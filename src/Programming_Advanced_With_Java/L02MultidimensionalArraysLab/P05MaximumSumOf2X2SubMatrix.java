package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                    .split(", ")).mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }

        int sum = Integer.MIN_VALUE;
        int[][] result = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > sum) {
                    sum = currentSum;
                    result[0][0] = matrix[row][col];
                    result[0][1] = matrix[row][col + 1];
                    result[1][0] = matrix[row + 1][col];
                    result[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.printf("%d ", result[row][col]);
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
