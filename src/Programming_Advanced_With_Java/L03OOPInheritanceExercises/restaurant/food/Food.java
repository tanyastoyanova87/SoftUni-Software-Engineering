package Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.food;

import Programming_Advanced_With_Java.L03OOPInheritanceExercises.restaurant.Product;

import java.math.BigDecimal;

public class Food extends Product {
    private double grams;
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }
    public double getGrams() {
        return grams;
    }
}
