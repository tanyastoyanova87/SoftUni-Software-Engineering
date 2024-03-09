package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.beverages.cold_beverage;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.beverages.Beverage;

import java.math.BigDecimal;

public class ColdBeverage extends Beverage {
    public ColdBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
