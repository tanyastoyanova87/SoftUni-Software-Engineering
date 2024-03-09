package Programming_Advanced_With_Java.JavaAdvancedExams.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                return this.data.remove(elephant);
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        Elephant elephant = null;
        for (Elephant el : this.data) {
            if (el.getRetiredFrom().equals(retiredFrom)) {
                elephant = el;
            }
        }
        return elephant;
    }

    public Elephant getOldestElephant() {
        Elephant elephant = null;
        int oldest = Integer.MIN_VALUE;
        for (Elephant el : this.data) {
            if (el.getAge() > oldest) {
                oldest = el.getAge();
                elephant = el;
            }
        }
        return elephant;
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Saved elephants in the park:%n"));
        for (Elephant elephant : this.data) {
            sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom()));
        }
        return sb.toString();
    }
}
