package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P04WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();
        while (!"End".equals(input)) {

            Animal animal = createAnimal(input);
            Food food = createFood(scanner.nextLine());
            animal.makeSound();
            animal.eat(food);

            animals.add(animal);

            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static Food createFood(String input) {
        String[] tokens = input.split("\\s+");
        String foodType = tokens[0];
        Food food;

        if (foodType.equals("P04WildFarm.Vegetable")) {
            food = new Vegetable(Integer.parseInt(tokens[1]));
        } else {
            food = new Meat(Integer.parseInt(tokens[1]));
        }
        return food;
    }

    private static Animal createAnimal(String input) {
        String[] tokens = input.split("\\s+");
        String animalType = tokens[0];

        Animal animal;
        if (animalType.equals("P04WildFarm.Cat")) {
            animal = new Cat(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
        } else if (animalType.equals("P04WildFarm.Mouse")) {
            animal = new Mouse(animalType, tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        } else if (animalType.equals("P04WildFarm.Zebra")) {
            animal = new Zebra(animalType, tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        } else {
            animal = new Tiger(animalType, tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        }

        return animal;
    }
}
