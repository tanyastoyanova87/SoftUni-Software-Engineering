package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String topPlayer = "";
        int maxNum = 0;
        boolean isTrue = false;
        while (!command.equals("END")){
            String playerName = command;
            int goalsCount = Integer.parseInt(scanner.nextLine());

            if (goalsCount > maxNum){
                topPlayer = playerName;
                maxNum = goalsCount;
            }
            if (goalsCount >= 3){
                isTrue = true;
            }
            if (goalsCount >= 10){
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", topPlayer);
        if (isTrue){
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", maxNum);
        }else {
            System.out.printf("He has scored %d goals.%n", maxNum);
        }
    }
}
