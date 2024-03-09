package Programming_Advanced_With_Java.L08IteratorsAndComparatorsExercises.P05ComparingObjects;

public class Person  implements Comparable<Person>{
    String name;
    int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.equals(person.name)) {
            if (this.age == person.age) {
                if (this.town.equals(person.town)) {
                    return 0;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }
}
