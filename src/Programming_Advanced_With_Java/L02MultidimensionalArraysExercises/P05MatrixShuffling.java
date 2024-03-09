package Programming_Advanced_With_Java.L02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            String[] commandParts = command.split("\\s+");

            if (isValid(commandParts, rows, cols)) {
                int firstNumCoordinates = Integer.parseInt(commandParts[1]);
                int secondNumCoordinates = Integer.parseInt(commandParts[2]);
                int firstNumCoordinates2 = Integer.parseInt(commandParts[3]);
                int secondNumCoordinates2 = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[firstNumCoordinates][secondNumCoordinates];
                String secondElement = matrix[firstNumCoordinates2][secondNumCoordinates2];

                matrix[firstNumCoordinates][secondNumCoordinates] = secondElement;
                matrix[firstNumCoordinates2][secondNumCoordinates2] = firstElement;

                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(String[] commandParts, int rows, int cols) {
        if (commandParts.length != 5) {
            return false;
        }

        if (!"swap".equals(commandParts[0])) {
            return false;
        }

        int firstNumCoordinates = Integer.parseInt(commandParts[1]);
        int secondNumCoordinates = Integer.parseInt(commandParts[2]);
        int firstNumCoordinates2 = Integer.parseInt(commandParts[3]);
        int secondNumCoordinates2 = Integer.parseInt(commandParts[4]);

        return firstNumCoordinates >= 0 && firstNumCoordinates < rows && secondNumCoordinates >= 0 && secondNumCoordinates < cols
                && firstNumCoordinates2 >= 0 && firstNumCoordinates2 < rows && secondNumCoordinates2 >= 0 && secondNumCoordinates2 < cols;

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
