package Programming_Advanced_With_Java.P01Vehicles;

public class Truck extends Vehicle {

    private static final double INCREASE_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double litres) {
        litres *= 0.95;
        super.refuel(litres);
    }
}
