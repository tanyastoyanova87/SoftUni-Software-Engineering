package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        List<String> directions = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        fillMatrix(scanner, matrix);

        int rowMatrix = 0;
        int colMatrix = 0;
        int robbedMoney = 0;
        boolean caught = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'D') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '+';
                }
            }
        }

        while (!directions.isEmpty()) {
            if (("left".equals(directions.get(0)) && colMatrix == 0) ||
                    ("right".equals(directions.get(0)) && colMatrix == matrix.length - 1) ||
                    ("up".equals(directions.get(0)) && rowMatrix == 0) ||
                    ("down".equals(directions.get(0)) && rowMatrix == matrix[0].length - 1)) {
                System.out.println("You cannot leave the town, there is police outside!");
                directions.remove(0);
                continue;
            }

            switch (directions.get(0)) {
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
            directions.remove(0);

            if (matrix[rowMatrix][colMatrix] == '$') {
                matrix[rowMatrix][colMatrix] = '+';
                int robbed = rowMatrix * colMatrix;
                robbedMoney += robbed;
                System.out.printf("You successfully stole %d$.%n", robbed);
            } else if (matrix[rowMatrix][colMatrix] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", robbedMoney);
                matrix[rowMatrix][colMatrix] = '#';
                caught = true;
                break;
            }
        }


        if (directions.isEmpty() && !caught) {
            matrix[rowMatrix][colMatrix] = 'D';
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", robbedMoney);
            printMatrix(matrix);

        } else {
            printMatrix(matrix);
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

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
