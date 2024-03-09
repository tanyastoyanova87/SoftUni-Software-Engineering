package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int hits = 0;
        int battleCruiser = 0;
        while (battleCruiser < 3) {
            String command = scanner.nextLine();

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

            if (matrix[rowMatrix][colMatrix] == '*') {
                matrix[rowMatrix][colMatrix] = '-';
                hits++;
                if (hits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", rowMatrix, colMatrix);
                    break;
                }
            } else if (matrix[rowMatrix][colMatrix] == 'C') {
                matrix[rowMatrix][colMatrix] = '-';
                battleCruiser++;
            }
        }

        if (battleCruiser == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        matrix[rowMatrix][colMatrix] = 'S';
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

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
