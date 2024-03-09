package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrixW = 0;
        int colMatrixW = 0;
        int rowMatrixB = 0;
        int colMatrixB = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'w') {
                    rowMatrixW = row;
                    colMatrixW = col;
                } else if (matrix[row][col] == 'b') {
                    rowMatrixB = row;
                    colMatrixB = col;
                }
            }
        }

        boolean isHit = false;
        while (rowMatrixW != 0 && rowMatrixB != 7 && !isHit) {

            if (whitePawHitBlack(rowMatrixW, colMatrixW, rowMatrixB, colMatrixB)) {
                String coordinates = findCoordinates(rowMatrixB, colMatrixB);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;
            }
            rowMatrixW--;

            if (blackPawHitWhite(rowMatrixB, colMatrixB, rowMatrixW, colMatrixW)) {
                String coordinates = findCoordinates(rowMatrixW, colMatrixW);
                System.out.printf("Game over! Black capture on %s.", coordinates);
                isHit = true;
            }
            rowMatrixB++;
        }

        if (!isHit) {
            System.out.print(rowMatrixW == 0
                    ? "Game over! White pawn is promoted to a queen at " + findCoordinates(rowMatrixW, colMatrixW) + "."
                    : "Game over! Black pawn is promoted to a queen at " + findCoordinates(rowMatrixB, colMatrixB) + "."
            );
        }
    }

    private static boolean blackPawHitWhite(int rowMatrixB, int colMatrixB, int rowMatrixW, int colMatrixW) {
        if (rowMatrixB + 1 == rowMatrixW && (colMatrixB + 1 == colMatrixW || colMatrixB - 1 == colMatrixW)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean whitePawHitBlack(int rowMatrixW, int colMatrixW, int rowMatrixB, int colMatrixB) {
        if (rowMatrixW - 1 == rowMatrixB && (colMatrixW + 1 == colMatrixB || colMatrixW - 1 == colMatrixB)) {
            return true;
        } else {
            return false;
        }
    }

    private static String findCoordinates(int rowMatrixB, int colMatrixB) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[colMatrixB]).append(row[rowMatrixB]);
        return sb.toString();
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}