package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int allTickets = 0;
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        int totalTickets = 0;

        while (!input.equals("Finish")){
            String movieName = input;

            int availableSeats = Integer.parseInt(scanner.nextLine());

            allTickets = 0;
            String command = scanner.nextLine();
            while (!command.equals("End")){
            String typeTickets = command;
            allTickets++;
                if (typeTickets.equals("student")){
                    studentTickets++;
                } else if (typeTickets.equals("standard")) {
                    standardTickets++;
                } else if (typeTickets.equals("kid")) {
                    kidTickets++;
                }


                if (allTickets >= availableSeats){
                    break;
                }
                command = scanner.nextLine();
            }
            totalTickets += allTickets;
            double percentFilled = (allTickets * 1.0 / availableSeats) * 100;
            System.out.printf("%s - %.2f%% full.%n", movieName, percentFilled);

            input = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalTickets);
        double percentStudentTickets = studentTickets * 1.0 / totalTickets * 100;
        double percentStandardTickets = standardTickets * 1.0 / totalTickets * 100;
        double percentKidTickets = kidTickets * 1.0 / totalTickets * 100;
        System.out.printf("%.2f%% student tickets.%n", percentStudentTickets);
        System.out.printf("%.2f%% standard tickets.%n", percentStandardTickets);
        System.out.printf("%.2f%% kids tickets.%n", percentKidTickets);
    }
}
