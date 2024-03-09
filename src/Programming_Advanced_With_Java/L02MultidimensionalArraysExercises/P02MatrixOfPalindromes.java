package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (String [] row : matrix) {
            for (String letters : row) {
                System.out.print(letters + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char startLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
        }
    }
}
