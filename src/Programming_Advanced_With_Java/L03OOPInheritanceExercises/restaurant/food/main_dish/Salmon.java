package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food.main_dish;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    private static final double SALMON_GRAMS = 22;
    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
