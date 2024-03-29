package Programming_Advanced_With_Java.JavaAdvancedExams.hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown;

    @Override
    public String toString() {
        return String.format("P01SortByNameAndAge.P02SalaryIncrease.P03ValidationData.P04FirstAndReserveTeam.P03ShoppingSpree.P03SayHelloP04SayHelloExtended.Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P01DefineAnInterfacePerson.Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P02MultipleImplementation.Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P04FoodShortage.Person %s: %d, Age: %d, Hometown: %s", getName(), getId(), getAge(), getHometown());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;


    }
}
