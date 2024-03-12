package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionExercises.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!"Let the Force be with you".equals(command)) {
            int[] coordinatesPeter = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evilCoordinates[0];
            int colEvil = evilCoordinates[1];

            getEvilRowsAndCols(matrix, rowEvil, colEvil);

            int rowPeter = coordinatesPeter[0];
            int colPeter = coordinatesPeter[1];

            sum = getSum(matrix, sum, rowPeter, colPeter);

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static long getSum(int[][] matrix, long sum, int rowPeter, int colPeter) {
        while (rowPeter >= 0 && colPeter < matrix[1].length) {
            if (rowPeter < matrix.length && colPeter >= 0 && colPeter < matrix[0].length) {
                sum += matrix[rowPeter][colPeter];
            }

            colPeter++;
            rowPeter--;
        }
        return sum;
    }

    private static void getEvilRowsAndCols(int[][] matrix, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil < matrix.length && colEvil < matrix[0].length) {
                matrix[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}
