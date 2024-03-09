package Programming_Advanced_With_Java.JavaAdvancedExams.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                this.data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animal;
        for (Animal a : this.data) {
            if (a.getName().equals(name) && a.getCaretaker().equals(caretaker)) {
                animal = a;
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = null;
        for (Animal animal : this.data) {
            if (oldestAnimal == null) {
                oldestAnimal = animal;
            }
            if (animal.getAge() > oldestAnimal.getAge()) {
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:%n"));
        for (Animal animal : this.data) {
            sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker()));
        }
        return sb.toString();
    }
}
