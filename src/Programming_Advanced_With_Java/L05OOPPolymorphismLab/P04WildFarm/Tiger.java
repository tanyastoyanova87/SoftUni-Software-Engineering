package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("P04WildFarm.Meat");
    }
}
