package Programming_Advanced_With_Java.JavaAdvancedExams.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

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

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot r: this.data){
            if(r.getName().equals(name)){
                r.setAvailable(false);
                toReturn = r;
            }
        }
        return toReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldSpecies = new ArrayList<>();
        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldSpecies.add(parrot);
            }
        }
        return soldSpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", this.name));
        for (Parrot p : this.data) {
            if (p.isAvailable()) {
                sb.append(String.format("%s%n", p));
            }
        }
        return sb.toString();
    }
}
