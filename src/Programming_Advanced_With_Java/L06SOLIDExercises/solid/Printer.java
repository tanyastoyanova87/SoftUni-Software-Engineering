package Programming_Advanced_With_Java.L06SOLIDExercises.solid;

import Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.Product;
import Programming_Advanced_With_Java.L06SOLIDExercises.solid.products.calculators.Calculator;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";
    private Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.total(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
