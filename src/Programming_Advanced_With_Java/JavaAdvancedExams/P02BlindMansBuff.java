package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;
import java.util.stream.Stream;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Stream.of(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        int rowMatrix = 0;
        int colMatrix = 0;

        int opponentsTouched = 0;
        int moves = 0;

        fillMatrix(rows, matrix, scanner);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("B")) {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = "-";
                }
            }
        }

        String direction;
        while (!(direction = scanner.nextLine()).equals("Finish")) {
            if (("left".equals(direction) && colMatrix == 0) ||
                    ("right".equals(direction) && colMatrix == matrix.length - 1) ||
                    ("up".equals(direction) && rowMatrix == 0) ||
                    ("down".equals(direction) && rowMatrix == matrix[0].length - 1)) {
                continue;
            }

            switch(direction) {
                case "left":
                    if (matrix[rowMatrix][colMatrix - 1].equals("O")) {
                        continue;
                    }
                    break;
                case "right":
                    if (matrix[rowMatrix][colMatrix + 1].equals("O")) {
                        continue;
                    }
                    break;
                case "up":
                    if (matrix[rowMatrix - 1][colMatrix].equals("O")) {
                        continue;
                    }
                    break;
                case "down":
                    if (matrix[rowMatrix + 1][colMatrix].equals("O")) {
                        continue;
                    }
                    break;
            }

            moves++;
            switch (direction) {
                case "left":
                    colMatrix--;
                    break;
                case "right":
                    colMatrix++;
                    break;
                case "up":
                    rowMatrix--;
                    break;
                case "down":
                    rowMatrix++;
                    break;

            }

            if (matrix[rowMatrix][colMatrix].equals("P")) {
                opponentsTouched++;
                matrix[rowMatrix][colMatrix] = "-";

                if (opponentsTouched == 3) {
                    break;
                }
            }
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponentsTouched, moves);
    }

    private static void fillMatrix(int rows, String[][] matrix, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
