package Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.aquariums;

import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Decoration;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static Programming_Advanced_With_Java.JavaOOPExams.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishes;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fishes = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity <= this.fishes.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fishes.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fishes.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fishes.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):%n", this.name, this.getClass().getSimpleName()));
        sb.append("Fish:");
        if (this.fishes.isEmpty()) {
            sb.append(" none");
            sb.append(System.lineSeparator());
        } else {
            for (Fish fish : this.fishes) {
                sb.append(" ").append(fish.getName());
            }
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Decorations: %d%n", this.decorations.size()));
        sb.append(String.format("Comfort: %d%n", calculateComfort()));
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fishes;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}


