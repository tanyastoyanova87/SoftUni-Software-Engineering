package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        List<String> directions = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        fillMatrix(scanner, matrix);

        int rowMatrix = 0;
        int colMatrix = 0;
        int allBombs = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    rowMatrix = row;
                    colMatrix = col;
                } else if (matrix[row][col] == 'B') {
                    allBombs++;
                }
            }
        }

        int bombs = 0;
        boolean out = false;

        while (bombs < allBombs && !directions.isEmpty()) {

            if (("left".equals(directions.get(0)) && colMatrix == 0) ||
                    ("right".equals(directions.get(0)) && colMatrix == matrix.length - 1) ||
                    ("up".equals(directions.get(0)) && rowMatrix == 0) ||
                    ("down".equals(directions.get(0)) && rowMatrix == matrix[0].length - 1)) {
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

            if (matrix[rowMatrix][colMatrix] == 'e') {
                out = true;
                break;
            }

            if (matrix[rowMatrix][colMatrix] == 'B') {
                matrix[rowMatrix][colMatrix] = '+';
                bombs++;
                System.out.println("You found a bomb!");
            }
        }

        if (bombs >= allBombs) {
            System.out.println("Congratulations! You found all bombs!");
        }else if (out) {
            System.out.printf("END! %d bombs left on the field%n", allBombs - bombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", allBombs - bombs, rowMatrix, colMatrix);
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
