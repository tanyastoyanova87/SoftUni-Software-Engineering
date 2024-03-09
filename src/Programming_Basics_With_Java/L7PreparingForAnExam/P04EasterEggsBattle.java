package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsCountFirstPlayer = Integer.parseInt(scanner.nextLine());
        int eggsCountSecondPlayer = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String winner = command;

            switch (winner) {
                case "one":
                    eggsCountSecondPlayer--;
                    break;
                case "two":
                    eggsCountFirstPlayer--;
                    break;
            }
            if (eggsCountFirstPlayer == 0 || eggsCountSecondPlayer == 0){
                break;
            }
            command = scanner.nextLine();
        }
        if (eggsCountFirstPlayer <= 0){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.%n", eggsCountSecondPlayer);
        }else if (eggsCountSecondPlayer <= 0){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.%n", eggsCountFirstPlayer);
        }
        if (command.equals("End")) {
            System.out.printf("Player one has %d eggs left.%n", eggsCountFirstPlayer);
            System.out.printf("Player two has %d eggs left.%n", eggsCountSecondPlayer);
        }
    }
}
