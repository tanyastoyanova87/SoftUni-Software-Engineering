package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());

        double charityAllDays = 0;
        int winsAllDays = 0;
        int losesAllDays = 0;

        for (int i = 1; i <= tournaments; i++) {
            String command = scanner.nextLine();

                double charity = 0;
                int wins = 0;
                int loses = 0;
            while (!command.equals("Finish")) {
                String sport = command;

                    String winOrLose = scanner.nextLine();
                    if (winOrLose.equals("win")) {
                        charity += 20;
                        wins++;
                    } else if (winOrLose.equals("lose")) {
                        loses++;
                    }


                    command = scanner.nextLine();

                }
                if (wins > loses) {
                    charity = charity + (charity * 0.10);
                    charityAllDays += charity;
                    winsAllDays++;
                } else {
                    charityAllDays += charity;
                    losesAllDays++;
                }
            }
            if (winsAllDays > losesAllDays) {
                charityAllDays = charityAllDays + (charityAllDays * 0.20);
                System.out.printf("You won the tournament! Total raised money: %.2f%n", charityAllDays);
            } else {
                System.out.printf("You lost the tournament! Total raised money: %.2f%n", charityAllDays);
            }
        }
    }

