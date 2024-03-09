package Programming_Advanced_With_Java.JavaAdvancedExams.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    //•	material: String
    //•	capacity: int

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg){
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)){
                return this.data.remove(egg);
            }
        }

        return false;
    }

    public Egg getStrongestEgg(){
        Egg egg = null;
        int strongest = Integer.MIN_VALUE;
        for (Egg eg : this.data) {
            if (eg.getStrength() > strongest) {
                strongest = eg.getStrength();
                egg = eg;
            }
        }
        return egg;
    }

    public Egg getEgg(String color){
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", this.material));
        for (Egg egg : this.data) {
            sb.append(egg).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
