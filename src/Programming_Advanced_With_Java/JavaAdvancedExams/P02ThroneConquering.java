package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        boolean dead = false;
        boolean saved = false;
        while (energy > 0) {

            String[] command = scanner.nextLine().split("\\s+");
            String direction = command[0];
            int spawnRow = Integer.parseInt(command[1]);
            int spawnCol = Integer.parseInt(command[2]);
            matrix[spawnRow][spawnCol] = 'S';


            switch (direction) {
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        rowMatrix--;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        rowMatrix++;
                    }
                    break;
                case "right":
                    if (colMatrix + 1 < matrix.length) {
                        colMatrix++;
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        colMatrix--;
                    }
                    break;
            }
            energy--;

            if (energy <= 0) {
                matrix[rowMatrix][colMatrix] = 'X';
                dead = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == matrix[spawnRow][spawnCol]) {
                energy -= 2;
                if (energy <= 0) {
                    matrix[rowMatrix][colMatrix] = 'X';
                    dead = true;
                    break;
                } else {
                    matrix[rowMatrix][colMatrix] = '-';
                }
            } else if (matrix[rowMatrix][colMatrix] == 'H') {
                saved = true;
                matrix[rowMatrix][colMatrix] = '-';
                break;
            }
        }

        if (dead) {
            System.out.printf("Paris died at %d;%d.%n", rowMatrix, colMatrix);
        } else if (saved) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
