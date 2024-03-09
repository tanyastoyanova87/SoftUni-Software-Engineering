package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, matrix);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '-';
                }
            }
        }

        String command;
        StringBuilder text = new StringBuilder();
        text.append(input);
        while (!"end".equals(command = scanner.nextLine())) {

            if (("left".equals(command) && colMatrix == 0) ||
                    ("right".equals(command) && colMatrix == matrix.length - 1) ||
                    ("up".equals(command) && rowMatrix == 0) ||
                    ("down".equals(command) && rowMatrix == matrix[0].length - 1)) {
                if (text.length() >= 1) {
                    text.deleteCharAt(text.length() - 1);
                    continue;
                } else {
                    continue;
                }
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

            if (Character.isLetter(matrix[rowMatrix][colMatrix])) {
                char c = (matrix[rowMatrix][colMatrix]);
                text.append(c);
                matrix[rowMatrix][colMatrix] = '-';
            }
        }

        matrix[rowMatrix][colMatrix] = 'P';

        System.out.println(text);
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
