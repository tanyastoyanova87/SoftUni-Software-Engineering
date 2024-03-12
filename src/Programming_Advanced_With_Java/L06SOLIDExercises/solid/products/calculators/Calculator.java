package Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.calculators;

import Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.Product;

import java.util.List;

public interface Calculator {
    double total(List<Product> products);
    double average(List<Product> products);
}
