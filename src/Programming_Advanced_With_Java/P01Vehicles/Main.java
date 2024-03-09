package Programming_Advanced_With_Java.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String[] truckTokens = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Car", car);
        vehicleMap.put("Programming_Advanced_With_Java.P01Vehicles.Programming_Advanced_With_Java.P02VehiclesExtension.Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s");
            String command = tokens[0];
            String vehicle = tokens[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicleMap.get(vehicle).drive(distance));
                    break;
                case "Refuel":
                    double litres = Double.parseDouble(tokens[2]);
                    vehicleMap.get(vehicle).refuel(litres);
                    break;
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }
}
