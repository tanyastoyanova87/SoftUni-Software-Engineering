package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split("\\s")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            String[] rowCowRadius = input.split("\\s");
            int row = Integer.parseInt(rowCowRadius[0]);
            int col = Integer.parseInt(rowCowRadius[1]);
            int radius = Integer.parseInt(rowCowRadius[2]);

            for (int r = row - radius; r <= row + radius ; r++) {
                if (isValid(row, col, matrix)) {
                    matrix.get(r).remove(col);
                }
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && col >= 0 && row < matrix.size() && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num++);
            }
        }
    }
}
