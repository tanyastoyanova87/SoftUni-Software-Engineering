package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.beverages.hot_beverage;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.beverages.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
