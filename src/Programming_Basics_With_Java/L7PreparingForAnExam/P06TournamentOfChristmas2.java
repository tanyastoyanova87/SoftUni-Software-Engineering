package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P06TournamentOfChristmas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysTournament = Integer.parseInt(scanner.nextLine());

        double money = 0;
        double totalMoney = 0;
        int wins = 0;
        int loses = 0;
        int totalWins = 0;
        int totalLoses = 0;

        for (int i = 1; i <= daysTournament ; i++) {
            String command = scanner.nextLine();

            while (!command.equals("Finish")){
            String sport = command;
            String winOrLose = scanner.nextLine();

                if (winOrLose.equals("win")){
                    money += 20;
                    wins++;
                    totalWins++;
                } else if (winOrLose.equals("lose")) {
                    loses++;
                    totalLoses++;
                }
                command = scanner.nextLine();
            }
                if (wins > loses){
                money = money + money * 0.10;
            }
            wins = 0;
            loses = 0;
            totalMoney += money;
            money = 0;

        }
        if (totalWins > totalLoses){
            totalMoney = totalMoney + totalMoney * 0.20;
            System.out.printf("You won the tournament! Total raised money: %.2f%n", totalMoney);
        }else {
            System.out.printf("You lost the tournament! Total raised money: %.2f%n", totalMoney);
        }
    }
}
