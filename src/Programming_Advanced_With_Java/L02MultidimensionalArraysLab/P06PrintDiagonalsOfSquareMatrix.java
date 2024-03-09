package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = elements;
        }
        getFirstDiagonal(matrix, size);
        System.out.println();
        getSecondDiagonal(matrix, size);
    }

    private static void getSecondDiagonal(int[][] matrix, int size) {
        for (int col = 0; col < size; col++) {
            System.out.print(matrix[size - 1 - col][col] + " ");
        }
    }

    private static void getFirstDiagonal(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }
}
