package Programming_Advanced_With_Java.JavaAdvancedExams.automotiveRepairShop;

import java.util.*;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        return vehicles.remove(vehicleToRemove);
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Vehicle lowestMileage = null;
        for (Vehicle vehicle : this.vehicles) {
            if (lowestMileage == null) {
                lowestMileage = vehicle;
            }
            if (vehicle.getMileage() < lowestMileage.getMileage()) {
                lowestMileage = vehicle;
            }
        }
        return lowestMileage;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        for (Vehicle vehicle : this.vehicles) {
            sb.append(vehicle.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
