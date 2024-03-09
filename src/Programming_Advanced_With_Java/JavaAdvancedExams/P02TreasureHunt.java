package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, rows, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'Y') {
                    rowMatrix = row;
                    colMatrix = col;
                }
            }
        }

        String command = scanner.nextLine();
        List<String> directions = new ArrayList<>();
        while (!"Finish".equals(command)) {

            switch (command) {
                case "up":
                    rowMatrix--;
                    break;
                case "down":
                    rowMatrix++;
                    break;
                case "right":
                    colMatrix++;
                    break;
                case "left":
                    colMatrix--;
                    break;
            }

            if (rowMatrix < 0 || rowMatrix >= rows || colMatrix < 0 || colMatrix >= cols) {
                switch (command) {
                    case "up":
                        rowMatrix++;
                        break;
                    case "down":
                        rowMatrix--;
                        break;
                    case "right":
                        colMatrix--;
                        break;
                    case "left":
                        colMatrix++;
                        break;
                }

            } else if (matrix[rowMatrix][colMatrix] == 'T') {
                switch (command) {
                    case "up":
                        rowMatrix++;
                        break;
                    case "down":
                        rowMatrix--;
                        break;
                    case "right":
                        colMatrix--;
                        break;
                    case "left":
                        colMatrix++;
                        break;
                }
            } else {
                directions.add(command);
            }

            command = scanner.nextLine();
        }

        if (matrix[rowMatrix][colMatrix] == 'X') {
            System.out.println("I've found the treasure!");
            String join = String.join(", ", directions);
            System.out.println("The right path is " + join);
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void fillMatrix(char[][] matrix, int rows, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
