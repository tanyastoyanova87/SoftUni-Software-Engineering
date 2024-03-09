package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        int rows = sizes[0];
        int cols = sizes[1];

        char[][] matrix = new char[rows][cols];
        fillMatrix(rows, matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int cheesePositions = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'M') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '*';
                } else if (matrix[row][col] == 'C') {
                    cheesePositions++;
                }
            }
        }

        int cheese = 0;
        String command;
        while (!"danger".equals(command = scanner.nextLine())) {

            int previousRow = rowMatrix;
            int previousCol = colMatrix;

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
                matrix[previousRow][previousCol] = 'M';
                System.out.println("No more cheese for tonight!");
                break;
            }

            if (matrix[rowMatrix][colMatrix] == '@') {
                rowMatrix = previousRow;
                colMatrix = previousCol;
                continue;
            }

            if (matrix[rowMatrix][colMatrix] == 'C') {
                cheese++;
                matrix[rowMatrix][colMatrix] = '*';
                if (cheese == cheesePositions) {
                    matrix[rowMatrix][colMatrix] = 'M';
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (matrix[rowMatrix][colMatrix] == 'T') {
                matrix[rowMatrix][colMatrix] = 'M';
                System.out.println("P04WildFarm.P04WildFarm.Mouse is trapped!");
                break;
            }

        }

        if ("danger".equals(command) && cheese < cheesePositions) {
            matrix[rowMatrix][colMatrix] = 'M';
            System.out.println("P04WildFarm.P04WildFarm.Mouse will come back later!");
        }

        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(char[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int rows, char[][] matrix, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
