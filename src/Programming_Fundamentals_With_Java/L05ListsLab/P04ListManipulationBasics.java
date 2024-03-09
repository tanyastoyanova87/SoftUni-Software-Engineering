package Programming_Fundamentals_With_Java.L05ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());


        while (true) {
        String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }
            String[] commands = command.split(" ");

            if (commands[0].equals("Add")) {
                int numberToAdd = Integer.parseInt(commands[1]);
                numbers.add(numberToAdd);

            } else if (commands[0].equals("Remove")) {
                int numberToRemove = Integer.parseInt(commands[1]);
                numbers.remove(Integer.valueOf(numberToRemove));

            } else if (commands[0].equals("RemoveAt")) {
                int numberToRemoveAt = Integer.parseInt(commands[1]);
                numbers.remove(numberToRemoveAt);

            } else if (commands[0].equals("Insert")) {
                int numberToInsert = Integer.parseInt(commands[1]);
                int indexToInsert = Integer.parseInt(commands[2]);
                numbers.add(indexToInsert, numberToInsert);
            }
        }
        for (int num : numbers) {
            System.out.printf("%d ", num);
        }
    }
}
