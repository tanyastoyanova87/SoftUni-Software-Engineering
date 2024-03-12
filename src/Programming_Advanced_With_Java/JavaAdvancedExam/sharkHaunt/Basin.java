package Programming_Advanced_With_Java.JavaAdvancedExam.sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {

    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.sharks.size() < this.capacity) {
            this.sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                return this.sharks.remove(shark);
            }
        }
        return false;
    }

    public Shark getLargestShark() {
        Shark shark = null;
        int largest = Integer.MIN_VALUE;
        for (Shark shark1 : this.sharks) {
            if (shark1.getLength() > largest) {
                largest = shark1.getLength();
                shark = shark1;
            }
        }
        return shark;
    }

    public Shark getShark(String kind) {
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    public int getCount() {
        return this.sharks.size();
    }

    public int getAverageLength() {
        int totalLength = 0;
        for (Shark shark : this.sharks) {
            int length = shark.getLength();
            totalLength += length;
        }
        return totalLength / this.sharks.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sharks in %s:%n", this.name)).trimToSize();

        for (Shark shark : this.sharks) {
            sb.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.%n"
                    , shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()));
        }
        return sb.toString().trim();
    }
}
