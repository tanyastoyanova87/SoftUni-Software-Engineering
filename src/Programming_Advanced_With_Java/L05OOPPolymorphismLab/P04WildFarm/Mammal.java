package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("P04WildFarm.Vegetable");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), df.format(super.getAnimalWeight()),
                this.livingRegion, super.getFoodEaten());
    }
}
