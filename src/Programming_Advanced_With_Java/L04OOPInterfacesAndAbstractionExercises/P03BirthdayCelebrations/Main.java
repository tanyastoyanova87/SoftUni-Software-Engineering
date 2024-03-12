package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!"End".equals(line)) {

            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P04FoodShortage.Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthableList.add(citizen);
                    break;
                case "Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthableList.add(pet);
                    break;
            }

            line = scanner.nextLine();
        }

        String date = scanner.nextLine();

        birthableList.stream()
                .filter(birthable -> birthable.getBirthDate()
                .endsWith(date))
                .forEach(birthable -> System.out.println(birthable.getBirthDate()));
    }
}
