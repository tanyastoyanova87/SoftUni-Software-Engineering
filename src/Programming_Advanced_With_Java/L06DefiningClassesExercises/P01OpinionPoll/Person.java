package Programming_Advanced_With_Java.L06DefiningClassesExercises.P01OpinionPoll;

public class Person {
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", getName(), getAge());
    }
}
