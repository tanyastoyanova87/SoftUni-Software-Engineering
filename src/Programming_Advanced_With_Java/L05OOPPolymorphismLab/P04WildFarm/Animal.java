package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public abstract boolean canEat(Food food);

    public void eat(Food food) {
        if (canEat(food)) {
            foodEaten += food.getQuantity();
        } else {
            System.out.printf("%ss are not eating that type of food!%n", this.getClass().getSimpleName());
        }
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
}
