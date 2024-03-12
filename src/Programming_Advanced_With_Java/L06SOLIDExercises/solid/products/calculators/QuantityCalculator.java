package Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.calculators;

import Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double total(List<Product> products) {
        return products.stream().mapToDouble(Product::getKilograms).sum();
    }

    @Override
    public double average(List<Product> products) {
        return total(products) / products.size();
    }
}
