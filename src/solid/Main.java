package solid;

import solid.products.Product;
import solid.products.calculators.Calculator;
import solid.products.calculators.CalorieCalculator;
import solid.products.calculators.QuantityCalculator;
import solid.products.drinks.Lemonade;
import solid.products.food.Chips;
import solid.products.food.Chocolate;

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
