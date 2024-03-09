package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] firstMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[row] = elements;
        }

        String[] rowsCols2 = scanner.nextLine().split("\\s+");
        int rows2 = Integer.parseInt(rowsCols2[0]);
        int cols2 = Integer.parseInt(rowsCols2[1]);

        int[][] secondMatrix = new int[rows2][cols2];
        for (int row = 0; row < rows2; row++) {
            int[] elements = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();

            secondMatrix[row] = elements;
        }

       if (rows != rows2 || cols != cols2) {
           System.out.println("not equal");
           return;
       }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
