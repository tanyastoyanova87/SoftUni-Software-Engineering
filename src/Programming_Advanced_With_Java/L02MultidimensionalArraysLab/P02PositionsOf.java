package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = elements;
        }

        boolean found = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("not found");
        }
    }
}
