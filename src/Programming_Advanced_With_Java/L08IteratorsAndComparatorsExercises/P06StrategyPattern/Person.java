package Programming_Advanced_With_Java.L08IteratorsAndComparatorsExercises.P06StrategyPattern;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }
}
