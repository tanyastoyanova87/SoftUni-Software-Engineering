package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05BestPlayer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String topPlayer = "";
        boolean isValid = false;
        int maxGoals = Integer.MIN_VALUE;
        while (!command.equals("END")){
            String playerName = command;

            int goalsCount = Integer.parseInt(scanner.nextLine());

            if (goalsCount > maxGoals){
                maxGoals = goalsCount;
                topPlayer = playerName;
            }
            if (goalsCount >= 3){
                isValid = true;
            }
            if (goalsCount >= 10) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", topPlayer);
        if (isValid){
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", maxGoals);
        }else {
            System.out.printf("He has scored %d goals.%n", maxGoals);
        }
    }
}
