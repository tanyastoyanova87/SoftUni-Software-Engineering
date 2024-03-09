package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNum = numbers[index1];
                int secondIndexNum = numbers[index2];

                numbers[index1] = secondIndexNum;
                numbers[index2] = firstIndexNum;

            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNum = numbers[index1];
                int secondIndexNum = numbers[index2];

                int result = firstIndexNum * secondIndexNum;
                numbers[index1] = result;
            } else if (command.contains("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers)
                .replace("[", "")
                .replace("]", ""));


       /* for (int i = 0; i < numbers.length - 1; i++) {
            int number = numbers[i];
            if (i != numbers.length - 1){
                System.out.print(number + ", ");
            }else {
                System.out.println(number);
            }
        }
        */
    }
}