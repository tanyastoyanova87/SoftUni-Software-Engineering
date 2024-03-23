package Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.houses;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.cat.Cat;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static Programming_Advanced_With_Java.JavaOOPExams.catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static Programming_Advanced_With_Java.JavaOOPExams.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= this.cats.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:%n", this.name, this.getClass().getSimpleName())); //TODO
        sb.append("Cats:");
        if (this.cats.isEmpty()) {
            sb.append(" none").append(System.lineSeparator());
        } else {
            for (Cat cat : this.cats) {
                sb.append(" ").append(cat.getName());
            }
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Toys: %d Softness: %d%n", this.toys.size(), sumSoftness()));
        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(this.cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(this.toys);
    }
}
