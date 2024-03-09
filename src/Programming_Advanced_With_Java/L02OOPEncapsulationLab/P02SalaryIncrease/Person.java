package Programming_Advanced_With_Java.L02OOPEncapsulationLab.P02SalaryIncrease;

public class Person {
    private final String TO_STRING_TEMPLATE = "%s %s gets %f leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    String getFirstName() {
        return firstName;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, getFirstName(), this.lastName, getSalary());
    }


    public void increaseSalary(double bonus) {
        if (getAge() < 30) {
            setSalary(getSalary() + (getSalary() * (bonus / 2) / 100));
        } else {
            setSalary(getSalary() + (getSalary() * bonus / 100));

        }
    }
}
