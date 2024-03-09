package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        fillMatrix(size, matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        int kilometers = 0;

        int firstRowT = 0;
        int firstColT = 0;
        int secondRolT = 0;
        int secondColT = 0;
        boolean foundFirstT = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("T") && !foundFirstT) {
                    foundFirstT = true;
                    firstRowT = row;
                    firstColT = col;
                }
                if (matrix[row][col].equals("T") && foundFirstT) {
                    secondRolT = row;
                    secondColT = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (("left".equals(command) && colMatrix == 0) ||
                    ("right".equals(command) && colMatrix == matrix.length - 1) ||
                    ("up".equals(command) && rowMatrix == 0) ||
                    ("down".equals(command) && rowMatrix == matrix[0].length - 1)) {
                continue;
            }

            kilometers += 10;
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

            if (matrix[rowMatrix][colMatrix].equals("T")) {
                kilometers += 20;
                matrix[rowMatrix][colMatrix] = ".";
                rowMatrix = secondRolT;
                colMatrix = secondColT;
                matrix[rowMatrix][colMatrix] = ".";

            } else if (matrix[rowMatrix][colMatrix].equals("F")) {
                break;
            }

            command = scanner.nextLine();
        }

        if (matrix[rowMatrix][colMatrix].equals("F")) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", kilometers);

        matrix[rowMatrix][colMatrix] = "C";
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

    private static void fillMatrix(int size, String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
