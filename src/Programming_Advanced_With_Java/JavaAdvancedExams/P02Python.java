package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",\\s+");

        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int countFood = 0;
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    rowPython = row;
                    colPython = col;
                } else if (matrix[row][col] == 'f') {
                    countFood++;
                }
            }
        }

        int pythonLength = 1;
        boolean isDead = false;
        for (String direction : directions) {
            switch (direction) {
                case "left":
                    colPython--;
                    break;
                case "right":
                    colPython++;
                    break;
                case "up":
                    rowPython--;
                    break;
                case "down":
                    rowPython++;
                    break;
            }
            if (rowPython < 0 || rowPython >= size) {
                if (rowPython < 0) {
                    rowPython = size - 1;
                }
                if (rowPython >= size) {
                    rowPython = 0;
                }
            }

            if (colPython < 0 || colPython >= size) {
                if (colPython < 0) {
                    colPython = size - 1;
                }
                if (colPython >= size) {
                    colPython = 0;
                }
            }

            if (countFood == 0) {
                break;
            }

            if (matrix[rowPython][colPython] == 'e') {
                isDead = true;
                break;
            }

            if (matrix[rowPython][colPython] == 'f') {
                pythonLength++;
                countFood--;
            }
        }
        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (countFood == 0) {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countFood);
        }
    }
}
