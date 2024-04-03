package Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.areas;

import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.animals.Animal;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static Programming_Advanced_With_Java.JavaOOPExams.zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):%n", this.name, this.getClass().getSimpleName()));
        sb.append("Animals:");
        if (this.animals.isEmpty()) {
            sb.append(" none").append(System.lineSeparator());
        } else {
            for (Animal animal : this.animals) {
                sb.append(" ").append(animal.getName());
            }
            sb.append(System.lineSeparator());
        }

        sb.append(String.format("Foods: %d%n", this.foods.size()));
        sb.append(String.format("Calories: %d%n", sumCalories()));
        return sb.toString().trim();
    }
}
