package Programming_Advanced_With_Java.JavaAdvancedExams.magazine;

import java.util.*;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        for (Cloth cloth : this.data) {
            if (cloth.getColor().equals(color)) {
                return this.data.remove(cloth);
            }
        }
        return false;
    }

    public Cloth getSmallestCloth() {
        Cloth cloth = null;
        int smallest = Integer.MAX_VALUE;
        for (Cloth c : this.data) {
            if (c.getSize() < smallest) {
                smallest = c.getSize();
                cloth = c;
            }
        }
        return cloth;
    }

    public Cloth getCloth(String color) {
        Cloth cloth = null;
        for (Cloth cloth1 : this.data) {
            if (cloth1.getColor().equals(color)) {
                cloth = cloth1;
            }
        }
        return cloth;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s magazine contains:%n", this.type));
        for (Cloth cloth : this.data) {
            sb.append(String.format("%s%n", cloth));
        }
        return sb.toString().trim();
    }
}
