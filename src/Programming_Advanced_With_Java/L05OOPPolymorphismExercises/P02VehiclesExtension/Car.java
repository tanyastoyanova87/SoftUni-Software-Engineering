package Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P02VehiclesExtension;

public class Car extends Vehicle {

    private static final double INCREASE_FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_CONSUMPTION, tankCapacity);
    }
}
