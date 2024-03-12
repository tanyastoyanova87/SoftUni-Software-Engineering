package Programming_Advanced_With_Java.L05OOPPolymorphismExercises.P02VehiclesExtension;

public class Bus extends Vehicle {
    private static  final double INCREASE_FUEL_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_CONSUMPTION, tankCapacity);
    }


}
