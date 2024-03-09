package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner
                        .nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                wagons.add(numberToAdd);
            } else {
                int passenger = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + passenger <= maxCapacity) {
                        wagons.set(i, currentWagon + passenger);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int num : wagons) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
