package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capacityLuggage = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        int luggageCount = 0;
        while (!command.equals("End")){
            double volume = Double.parseDouble(command);
            if (volume > capacityLuggage){
                break;
            }
            luggageCount++;

            if (luggageCount % 3 == 0){
                volume = volume + volume * 0.10;
            }
            capacityLuggage = (capacityLuggage - volume);


            command = scanner.nextLine();
        }
        if (command.equals("End")){
            System.out.println("Congratulations! All suitcases are loaded!");
        } else {
            System.out.println("No more space!");
        }

        System.out.printf("Statistic: %d suitcases loaded.%n", luggageCount);
    }
}
