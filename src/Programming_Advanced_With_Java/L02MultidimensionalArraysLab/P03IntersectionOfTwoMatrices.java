package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = elements[col].charAt(0);
            }
        }

        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = elements[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.print("* ");
                } else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
