package Programming_Advanced_With_Java.JavaOOPExams.catHouse.repositories;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository<T> implements Repository {
    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        return this.toys.stream().filter(toy -> toy.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
