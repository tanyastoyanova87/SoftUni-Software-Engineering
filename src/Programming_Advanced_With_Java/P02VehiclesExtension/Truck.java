package Programming_Advanced_With_Java.P02VehiclesExtension;

public class Truck extends Vehicle {

    private static final double INCREASE_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refuel(double litres) {
        litres *= 0.95;
        super.refuel(litres);
    }
}
