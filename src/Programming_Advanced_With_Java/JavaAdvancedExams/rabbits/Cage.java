package Programming_Advanced_With_Java.JavaAdvancedExams.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                return this.data.remove(rabbit);
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                this.data.remove(rabbit);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit r : this.data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                rabbit = r;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> sold = new ArrayList<>();

        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                sold.add(rabbit);
            }
        }
        return sold;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:%n", this.name));
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                sb.append(String.format("%s%n", rabbit));
            }
        }
        return sb.toString();
    }
}
