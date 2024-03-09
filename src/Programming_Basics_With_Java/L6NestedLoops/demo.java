package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int totalTickets = 0;
        while (!input.equals("Finish")){
            String movieName = input;
            int availableSeats = Integer.parseInt(scanner.nextLine());
            String command = scanner.nextLine();

            input = scanner.nextLine();

            while (!command.equals("End")){
                String ticketType = scanner.nextLine();

                switch (ticketType){
                    case "student":
                        totalTickets++;
                        break;
                    case "standard":
                        totalTickets++;
                        break;
                    case "kid":
                        totalTickets++;
                        break;
                }
                command = scanner.nextLine();
            }
                double filled = (totalTickets * 1.0 / availableSeats) * 100;
                System.out.printf("%s - %.2f%% full.%n", movieName, filled);
        }
    }
}
