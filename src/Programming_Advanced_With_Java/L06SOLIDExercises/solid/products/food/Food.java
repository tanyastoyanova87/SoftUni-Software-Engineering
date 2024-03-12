package Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.food;

import Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.Product;

public abstract class Food implements Product {
    private double grams;
    private double caloriesPer100Grams;

    public Food(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return this.grams / 1000;
    }
}
