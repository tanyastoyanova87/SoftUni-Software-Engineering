package Programming_Advanced_With_Java.JavaAdvancedExam;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int enemies = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("J")) {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = "-";
                } else if (matrix[row][col].equals("E")) {
                    enemies++;
                }
            }
        }

        int armour = 300;
        int hits = 0;
        boolean shotDown = false;

        while (armour > 0) {
            String command = scanner.nextLine();

            switch (command) {
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

            if (matrix[rowMatrix][colMatrix].equals("E")) {
                armour -= 100;
                hits++;
                matrix[rowMatrix][colMatrix] = "-";
                if (hits == 3 && armour == 0) {
                    shotDown = true;
                    break;
                }

            } else if (matrix[rowMatrix][colMatrix].equals("R")) {
                armour = 300;
                matrix[rowMatrix][colMatrix] = "-";

            }
            if (hits == enemies) {
                break;
            }
        }

        if (!shotDown) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n"
                    , rowMatrix, colMatrix);
        }

        matrix[rowMatrix][colMatrix] = "J";
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
