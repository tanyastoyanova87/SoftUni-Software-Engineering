package Programming_Advanced_With_Java.JavaAdvancedExams.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    //•	color: String
    //•	capacity: int
    //•	data: List<Present>

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                return this.data.remove(present);
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        Present present = null;
        double heaviest = Integer.MIN_VALUE;
        for (Present p : this.data) {
            if (p.getWeight() > heaviest) {
                heaviest = p.getWeight();
                present = p;
            }
        }
        return present;
    }

    public Present getPresent(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:%n", this.color));
        for (Present present : this.data) {
            sb.append(present).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
