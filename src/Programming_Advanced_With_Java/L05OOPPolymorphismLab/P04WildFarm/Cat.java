package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean canEat(Food food) {
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
       return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.breed, df.format(super.getAnimalWeight()),
                super.livingRegion, super.getFoodEaten());
    }
}
