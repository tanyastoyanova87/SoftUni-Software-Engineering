package Programming_Advanced_With_Java.JavaAdvancedExams.rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s", getSpecies(), getName());
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}
