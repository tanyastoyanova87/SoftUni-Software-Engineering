package Programming_Advanced_With_Java.JavaAdvancedExams.fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (this.fishes.size() < this.capacity) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                return this.fishes.remove(fish);
            }
        }
        return false;
    }

    public Fish getOldestFish() {
        Fish fish = null;
        int oldest = Integer.MIN_VALUE;
        for (Fish fish1 : this.fishes) {
            if (fish1.getAge() > oldest) {
                oldest = fish1.getAge();
                fish = fish1;
            }
        }
        return fish;
    }

    public Fish getFish(String species) {
        Fish fish = null;
        for (Fish fish1 : this.fishes) {
            if (fish1.getSpecies().equals(species)) {
                fish = fish1;
            }
        }
        return fish;
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        if (this.capacity > this.fishes.size()) {
            return this.capacity - this.fishes.size();
        }
        return 0;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fishes in the pond:%n"));
        for (Fish fish : this.fishes) {
            sb.append(String.format("This %s is %d years old and reproduces through %s.%n", fish.getSpecies(),
            fish.getAge(), fish.getMatingSeason()));
        }
        return sb.toString();
    }
}
