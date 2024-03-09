package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P03OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        List<Person> validPeople = new ArrayList<>();

        for (int count = 1; count <= countPeople ; count++) {
            String[] personalInfo = scanner.nextLine().split(" ");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                validPeople.add(person);
            }
        }
        for (Person person : validPeople) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
