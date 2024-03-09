package Programming_Advanced_With_Java.L02MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 4; //общ брой на редовете в матрицата
        int cols = 4; //общ брой на колони в матрицата
        //1. Какво е матрица?
        int [][] matrix = new int[rows][cols];
        //2. Как се чете матрица?
        //вариант 1 -> вложен for цикли
        for (int row = 0; row < rows; row++) { //обхожда редовете
            for (int col = 0; col < cols; col++) { //обхожда колоните
                matrix[row][col] = scanner.nextInt();
            }
        }
        //вариант 2 -> streamAPI
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        //вариант 3 -> for loop
        for (int row = 0; row < rows; row++) {
            String [] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix [row][col]= Integer.parseInt(input[col]);
            }
        }

        //3. Как се отпечатва матрица?
        //вариант 1 -> foreach
        for (int [] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        //вариант 2 -> for loop
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        //4. Движения в матрица
        //нагоре -> ред - 1
        //надолу -> ред + 1
        //дясно -> колона + 1
        //ляво-> колона - 1
        //case "up":
        //                    rowMatrix--;
        //                    break;
        //                case "down":
        //                    rowMatrix++;
        //                    break;
        //                case "right":
        //                    colMatrix++;
        //                    break;
        //                case "left":
        //                    colMatrix--;
        //                    break;


        //5. Валидиране на индекси
        //колона -> колона >= 0 и колона < брой колони
        //ред -> ред >= 0 и ред < брой редове

        //6.Намиране на елементи на второстепенен диагонал
        //matrix[matrix.length - 1 - i][i]


        // ако е на границата на матрицата и не трябва да излиза от нея:

        //switch (direction) {
        //                case "up":
        //                    if (rowMatrix - 1 >= 0) {
        //                        rowMatrix--;
        //                    }
        //                    break;
        //                case "down":
        //                    if (rowMatrix + 1 < matrix.length) {
        //                        rowMatrix++;
        //                    }
        //                    break;
        //                case "right":
        //                    if (colMatrix + 1 < matrix.length) {
        //                        colMatrix++;
        //                    }
        //                    break;
        //                case "left":
        //                    if (colMatrix - 1 >= 0) {
        //                        colMatrix--;
        //                    }
        //                    break;
        //            }

        //още един начин да проверим дали сме на границата на матрицата:
        //if (("left".equals(direction) && colMatrix == 0) ||
        //                    ("right".equals(direction) && colMatrix == matrix.length - 1) ||
        //                    ("up".equals(direction) && rowMatrix == 0) ||
        //                    ("down".equals(direction) && rowMatrix == matrix[0].length - 1)) {
        //                continue;
        //
        //            }

        // String collect = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        // когато излезем от матрицата и трябва да излезем от другата страна
        //if (rowMatrix < 0 || rowMatrix >= size) {
        //                if (rowMatrix < 0) {
        //                    rowMatrix = size - 1;
        //                }
        //                if (rowMatrix >= size) {
        //                    rowMatrix = 0;
        //                }
        //            }
        //
        //            if (colMatrix < 0 || colMatrix >= size) {
        //                if (colMatrix < 0) {
        //                    colMatrix = size - 1;
        //                }
        //                if (colMatrix >= size) {
        //                    colMatrix = 0;
        //                }
        //            }
    }
}
