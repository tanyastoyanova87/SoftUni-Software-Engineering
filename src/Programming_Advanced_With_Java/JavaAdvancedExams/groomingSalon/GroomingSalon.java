package Programming_Advanced_With_Java.JavaAdvancedExams.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                return p;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The grooming salon has the following clients:%n"));
        for (Pet pet : this.data) {
            stringBuilder.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return stringBuilder.toString();
    }
}

