package Programming_Advanced_With_Java.L03OOPInheritanceExercises.NeedForSpeed;

public class SportCar extends Car {
    private final static double DEFAULT_FUEL_CONSUMPTION = 10;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
