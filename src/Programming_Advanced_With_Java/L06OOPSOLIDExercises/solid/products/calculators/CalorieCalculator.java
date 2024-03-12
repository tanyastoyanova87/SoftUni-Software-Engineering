package Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.calculators;

import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator{

    @Override
    public double total(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getAmountOfCalories();
        }
        return sum;
    }

    public double average(List<Product> products) {
        return total(products) / products.size();
    }

}
