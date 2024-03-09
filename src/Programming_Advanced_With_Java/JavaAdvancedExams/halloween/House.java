package Programming_Advanced_With_Java.JavaAdvancedExams.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        for (Kid kid : this.data) {
            if (kid.getName().equals(name)) {
                this.data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public Kid getKid(String street) {
        for (Kid kid : this.data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children who visited a house for candy:").append(System.lineSeparator());
        System.out.println();
        for (Kid kid : this.data) {
            stringBuilder.append(String.format("%s from %s street", kid.getName(), kid.getStreet())).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
