package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food.starter;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food.Food;

import java.math.BigDecimal;

public class Starter extends Food {
    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
