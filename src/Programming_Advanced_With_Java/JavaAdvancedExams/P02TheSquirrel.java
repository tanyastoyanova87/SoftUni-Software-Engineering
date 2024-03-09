package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        List<String> directions = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        fillMatrix(matrix, scanner);

        int rowMatrix = 0;
        int colMatrix = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    rowMatrix = row;
                    colMatrix = col;
                    matrix[row][col] = '*';
                }
            }
        }

        int hazelnuts = 0;
        boolean out = false;
        boolean trap = false;
        while (!directions.isEmpty()) {

            switch (directions.get(0)) {
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

            if (rowMatrix < 0 || rowMatrix >= size || colMatrix < 0 || colMatrix >= size) {
                out = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == 'h') {
                hazelnuts++;
                matrix[rowMatrix][colMatrix] = '*';
                if (hazelnuts == 3) {
                    matrix[rowMatrix][colMatrix] = 's';
                    break;
                }
            } else if (matrix[rowMatrix][colMatrix] == 't') {
                trap = true;
                break;
            }

            directions.remove(0);
        }

        if (out) {
            System.out.println("The squirrel is out of the field.");
        } else if (trap) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (hazelnuts < 3) {
            System.out.println("There are more hazelnuts to collect.");
        } else {
            System.out.println("Good job! You have collected all hazelnuts!");
        }

        System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
