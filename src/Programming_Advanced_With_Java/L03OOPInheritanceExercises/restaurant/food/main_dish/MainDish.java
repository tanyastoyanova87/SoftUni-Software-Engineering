package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food.main_dish;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food.Food;

import java.math.BigDecimal;

public class MainDish extends Food {
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
