package Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P02VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {

        double neededFuel = this.fuelConsumption * distance;
        if (neededFuel > this.fuelQuantity) {
            if (this.getClass().getSimpleName().equals("Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P02VehiclesExtension.EmptyBus")) {
                return "Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P02VehiclesExtension.Bus needs refueling";
            }
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        DecimalFormat df = new DecimalFormat("#.##");
        this.fuelQuantity -= neededFuel;
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else {
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        }
    }

    public void refuel(double litres) {
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + litres > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += litres;
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
