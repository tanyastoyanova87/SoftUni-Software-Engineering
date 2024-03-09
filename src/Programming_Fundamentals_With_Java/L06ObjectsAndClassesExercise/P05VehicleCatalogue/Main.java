package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P05VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputSplit = input.split(" ");
            String typeOfVehicle = inputSplit[0];
            String model = inputSplit[1];
            String color = inputSplit[2];
            int horsePower = Integer.parseInt(inputSplit[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            vehicles.add(vehicle);

            input = scanner.nextLine();

        }

        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {

            for (Vehicle vehicle : vehicles) {
                if (model.equals(vehicle.getModel())) {
                    System.out.println(vehicle);
                    break;
                }
            }
            model  = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", getAverageHorsepower(vehicles, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", getAverageHorsepower(vehicles, "trucks"));
    }

    private static double getAverageHorsepower(List<Vehicle> vehicles, String type) {
        double sum = 0;
        int count = 0;
        if (type.equals("cars")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getTypeOfVehicle().equals("car")) {
                    sum += vehicle.getHorsepower();
                    count++;
                }
            }
        } else if (type.equals("trucks")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getTypeOfVehicle().equals("truck")) {
                    sum += vehicle.getHorsepower();
                    count++;
                }
            }
        }
        if (sum == 0) {
            return 0;
        }
        return sum / count;
    }
}
