package Programming_Fundamentals_With_Java.FinalExams;

import java.util.*;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mileageCar = new LinkedHashMap<>();
        Map<String, Integer> fuelCar = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String carInfo = scanner.nextLine();
            String[] carInfoSeparated = carInfo.split("\\|");

            String car = carInfoSeparated[0];
            int mileage = Integer.parseInt(carInfoSeparated[1]);
            int fuel = Integer.parseInt(carInfoSeparated[2]);
            mileageCar.put(car, mileage);
            fuelCar.put(car, fuel);
        }

        String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {

            String[] commandsSeparated = commands.split(" : ");
            String command = commandsSeparated[0];
            String car = commandsSeparated[1];

            if (command.equals("Drive")) {
                int distance = Integer.parseInt(commandsSeparated[2]);
                int fuel = Integer.parseInt(commandsSeparated[3]);

                if (fuelCar.get(car) < fuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    mileageCar.put(car, mileageCar.get(car) + distance);
                    fuelCar.put(car, fuelCar.get(car) - fuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                }

                if (mileageCar.get(car) >= 100000) {
                    mileageCar.remove(car);
                    fuelCar.remove(car);
                    System.out.printf("Time to sell the %s!%n", car);
                }

            } else if (command.equals("Refuel")) {
                int fuel = Integer.parseInt(commandsSeparated[2]);
                int currentFuel = fuelCar.get(car);

                fuelCar.put(car, fuelCar.get(car) + fuel);
                if (fuelCar.get(car) > 75) {
                    fuelCar.put(car, 75);
                    System.out.printf("%s refueled with %d liters%n", car, 75 - currentFuel);
                } else {
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                }


            } else if (command.equals("Revert")) {
                int kilometers = Integer.parseInt(commandsSeparated[2]);

                mileageCar.put(car, mileageCar.get(car) - kilometers);
                System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);

                if (mileageCar.get(car) < 10000) {
                    mileageCar.put(car, 10000);
                }
            }

            commands = scanner.nextLine();
        }

        for (String car : mileageCar.keySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileageCar.get(car), fuelCar.get(car));
        }
    }
}
