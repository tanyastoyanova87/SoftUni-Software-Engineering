package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        int shot = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            int index = Integer.parseInt(command);
            if (index >= 0 && index < targets.length && targets[index] != -1) {
                int shotValue = targets[index];
                targets[index] = -1;

                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] > shotValue) {
                        targets[i] -= shotValue;
                    } else if (targets[i] <= shotValue && targets[i] != -1) {
                        targets[i] += shotValue;
                    }
                }
            }

            command = scanner.nextLine();
        }

        int shotCount = countShotTargets(targets);

        System.out.printf("Shot targets: %d -> ", shotCount);
        for (int num : targets) {
            System.out.print(num + " ");
        }
    }

    public static int countShotTargets(int[] targets) {
        int count = 0;
        for (int target : targets) {
            if (target == -1) {
                count++;
            }
        }
        return count;

    }
}
