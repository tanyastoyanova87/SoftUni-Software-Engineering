package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int niceKidsCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                } else if (matrix[row][col] == 'V') {
                    niceKidsCount++;
                }
            }
        }

        int niceKidsPresents = 0;
        while (presentsCount > 0) {
            String command = scanner.nextLine();
            if ("Christmas morning".equals(command)) {
                break;
            }

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

            if (matrix[rowMatrix][colMatrix] == 'V') {
                niceKidsPresents++;
                presentsCount--;
                matrix[rowMatrix][colMatrix] = '-';

            } else if (matrix[rowMatrix][colMatrix] == 'X') {
                matrix[rowMatrix][colMatrix] = '-';

            } else if (matrix[rowMatrix][colMatrix] == 'C') {
                if (rowMatrix > 0 && matrix[rowMatrix - 1][colMatrix] == 'V') {
                    niceKidsPresents++;
                    matrix[rowMatrix - 1][colMatrix] = '-';
                    presentsCount--;
                }
                if (rowMatrix < matrix.length - 1 && matrix[rowMatrix + 1][colMatrix] == 'V') {
                    niceKidsPresents++;
                    matrix[rowMatrix + 1][colMatrix] = '-';
                    presentsCount--;
                }
                if (colMatrix > 0 && matrix[rowMatrix][colMatrix - 1] == 'V') {
                    niceKidsPresents++;
                    matrix[rowMatrix][colMatrix - 1] = '-';
                    presentsCount--;
                }
                if (colMatrix < matrix[0].length - 1 && matrix[rowMatrix][colMatrix + 1] == 'V') {
                    niceKidsPresents++;
                    matrix[rowMatrix][colMatrix + 1] = '-';
                    presentsCount--;
                }
                matrix[rowMatrix][colMatrix] = '-';
            }
        }

        if (presentsCount == 0) {
            System.out.println("Santa ran out of presents!");
        }

        matrix[rowMatrix][colMatrix] = 'S';
        printMatrix(matrix);

        if (niceKidsPresents == niceKidsCount) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKidsPresents);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsCount - niceKidsPresents);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
