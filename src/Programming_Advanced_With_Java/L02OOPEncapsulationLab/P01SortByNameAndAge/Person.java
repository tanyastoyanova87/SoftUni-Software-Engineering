package Programming_Advanced_With_Java.L02OOPEncapsulationLab.P01SortByNameAndAge;

public class Person {
    private final String TO_STRING_TEMPLATE = "%s %s is %d years old.";
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    String getFirstName() {
        return firstName;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, getFirstName(), this.lastName, getAge());
    }
}
