package Programming_Advanced_With_Java.JavaAdvancedExams.vendingSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine(6);

        Drink tea = new Drink("Tea", new BigDecimal("1.5"), 300);
        Drink coffee = new Drink("Coffee", new BigDecimal("2.0"), 120);
        Drink hotChocolate = new Drink("Hot Chocolate", new BigDecimal("2.5"), 200);
        Drink latte = new Drink("Latte", new BigDecimal("3.5"), 220);
        Drink cappuccino = new Drink("Cappuccino", new BigDecimal("2.8"), 180);
        Drink mocha = new Drink("Mocha", new BigDecimal("2.1"), 150);
        Drink herbalTea = new Drink("Herbal Tea", new BigDecimal("1.75"), 300);

        System.out.println(vendingMachine.getCount()); //0

        vendingMachine.addDrink(tea);
        vendingMachine.addDrink(coffee);
        vendingMachine.addDrink(hotChocolate);
        vendingMachine.addDrink(latte);
        vendingMachine.addDrink(cappuccino);
        vendingMachine.addDrink(mocha);

        vendingMachine.addDrink(herbalTea);

        System.out.println(vendingMachine.getCount()); //6

        System.out.println(vendingMachine.removeDrink("Herbal Tea")); // False
        System.out.println(vendingMachine.removeDrink("Tea")); // True

        System.out.println(vendingMachine.getLongest());

        System.out.println(vendingMachine.getCheapest()); //Name: Coffee, Price: $2.0, Volume: 120 ml

        System.out.println(vendingMachine.buyDrink("Latte")); //Name: Latte, Price: $3.5, Volume: 220 ml

        System.out.println(vendingMachine.report());


    }
}
