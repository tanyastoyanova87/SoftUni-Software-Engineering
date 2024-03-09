package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(scanner, matrix);

        int rowMatrix = 0;
        int colMatrix = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'M') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int cheese = 0;
        boolean out = false;

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            switch (command) {
                case "up":
                    rowMatrix--;
                    break;
                case "down":
                    rowMatrix++;
                    break;
                case "left":
                    colMatrix--;
                    break;
                case "right":
                    colMatrix++;
                    break;
            }

            if (rowMatrix < 0 || rowMatrix >= size || colMatrix < 0 || colMatrix >= size) {
                out = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == 'B') {
                matrix[rowMatrix][colMatrix] = '-';
                switch (command) {
                    case "up":
                        rowMatrix--;
                        break;
                    case "down":
                        rowMatrix++;
                        break;
                    case "left":
                        colMatrix--;
                        break;
                    case "right":
                        colMatrix++;
                        break;
                }
            }
            if (matrix[rowMatrix][colMatrix] == 'c') {
                matrix[rowMatrix][colMatrix] = '-';
                cheese++;
            }

            command = scanner.nextLine();
        }


        if (out) {
            System.out.println("Where is the mouse?");
        }

        if (cheese < 5) {
            if (!out) {
                matrix[rowMatrix][colMatrix] = 'M';
            }
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            if (!out) {
                matrix[rowMatrix][colMatrix] = 'M';
            }
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
