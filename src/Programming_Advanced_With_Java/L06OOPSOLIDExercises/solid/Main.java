package Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid;

import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.Product;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.calculators.Calculator;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.calculators.CalorieCalculator;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.calculators.QuantityCalculator;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.food.Chips;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.drinks.Lemonade;
import Programming_Advanced_With_Java.L06OOPSOLIDExercises.solid.products.food.Chocolate;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Chips(200));
        products.add(new Chocolate(400));
        products.add(new Lemonade(500));

        Calculator calculator = new CalorieCalculator();
        Calculator quantityCalculator = new QuantityCalculator();

        Printer printer = new Printer(calculator);
        printer.printSum(products);
        printer.printAverage(products);

        Printer printer1 = new Printer(quantityCalculator);
        printer1.printSum(products);
        printer1.printAverage(products);
    }
}
