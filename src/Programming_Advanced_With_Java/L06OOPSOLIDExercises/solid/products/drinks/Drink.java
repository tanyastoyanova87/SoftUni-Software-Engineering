package Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.drinks;

import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.Product;

public abstract class Drink implements Product {
    private double milliliters;
    private double caloriesPer100Grams;
    private double density;

    public Drink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }


    @Override
    public double getAmountOfCalories() {
        double grams = this.milliliters * density;
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return getLiters() * this.density;
    }

    public double getLiters() {
        return this.milliliters / 1000;
    }
}
