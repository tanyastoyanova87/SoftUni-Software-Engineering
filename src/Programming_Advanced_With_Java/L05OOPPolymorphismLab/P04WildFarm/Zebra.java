package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight,  livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

}
