package Programming_Advanced_With_Java.JavaAdvancedExams.shelter;

public class Main {
    public static void main(String[] args) {

        Shelter shelter = new Shelter(5);

        Animal animal = new Animal("Sharo", 2, "Pesho");

        System.out.println(animal);

        shelter.add(animal);

        System.out.println(shelter.remove("Gosho"));
        System.out.println(shelter.remove("Sharo"));

        Animal animal2 = new Animal("Rex", 1, "Ivan");
        Animal animal3 = new Animal("Oreo", 3, "Katya");

        shelter.add(animal2);
        shelter.add(animal3);

        Animal oldest = shelter.getOldestAnimal();
        System.out.println(oldest);

        Animal getAnimal = shelter.getAnimal("Oreo", "Katya");
        System.out.println(getAnimal);

        System.out.println(shelter.getCount());

        System.out.println(shelter.getStatistics());
    }
}