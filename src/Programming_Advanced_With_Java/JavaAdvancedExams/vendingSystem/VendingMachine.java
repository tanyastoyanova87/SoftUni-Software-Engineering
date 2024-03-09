package Programming_Advanced_With_Java.JavaAdvancedExams.vendingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                return this.drinks.remove(drink);
            }
        }
        return false;
    }

    public Drink getLongest() {
        Drink drink = null;
        int longest = Integer.MIN_VALUE;
        for (Drink drink1 : this.drinks) {
            if (drink1.getVolume() > longest) {
                longest = drink1.getVolume();
                drink = drink1;
            }
        }
        return drink;
    }

    public Drink getCheapest() {
        Drink drink = null;
        BigDecimal lowestPrice = BigDecimal.valueOf(Integer.MAX_VALUE);
        for (Drink drink1 : this.drinks) {
            if (drink1.getPrice().compareTo(lowestPrice) < 0) {
                lowestPrice = drink1.getPrice();
                drink = drink1;
            }
        }
        return drink;
    }

    public String buyDrink(String name) {
        Drink dr = null;
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                dr = drink;
            }
        }
        assert dr != null;
        return dr.toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Drinks available:%n"));
        for (Drink drink : this.drinks) {
            sb.append(String.format("%s%n", drink));
        }
        return sb.toString();
    }
}
