package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.beverages;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.Product;

import java.math.BigDecimal;

public class Beverage extends Product {
    private double milliliters;
    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
