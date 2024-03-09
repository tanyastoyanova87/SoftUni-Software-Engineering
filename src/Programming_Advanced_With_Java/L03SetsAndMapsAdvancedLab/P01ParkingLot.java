package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();
        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            String[] input = command.split(", ");
            String direction = input[0];
            String carNumber = input[1];

            if ("IN".equals(direction)) {
                carNumbers.add(carNumber);
            } else if ("OUT".equals(direction)) {
                carNumbers.remove(carNumber);
            }

            command = scanner.nextLine();
        }
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
