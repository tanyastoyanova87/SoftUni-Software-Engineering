package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P06OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] inputSplit = input.split(" ");
            String name = inputSplit[0];
            String id = inputSplit[1];
            int age = Integer.parseInt(inputSplit[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            input = scanner.nextLine();
        }

        people.sort(Comparator.comparingInt(Person::getAge));

        for (Person person : people) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }
    }
}
