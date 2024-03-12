package Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P01Vehicles;

public class Car extends Vehicle {

    private static final double INCREASE_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_CONSUMPTION);
    }
}
