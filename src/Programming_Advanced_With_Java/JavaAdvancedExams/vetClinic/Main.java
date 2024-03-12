package Programming_Advanced_With_Java.JavaAdvancedExams.vetClinic;

public class Main {
    public static void main(String[] args) {

        Clinic clinic = new Clinic(20);

// Initialize entity
        Pet dog = new Pet("Ellias", 5, "Tim");

// Print Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet
        System.out.println(dog); // Ellias 5 (Tim)

// Add Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet
        clinic.add(dog);

// Remove Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet
        System.out.println(clinic.remove("Ellias")); // true
        System.out.println(clinic.remove("Pufa")); // false

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        clinic.add(cat);
        clinic.add(bunny);

// Get Oldest Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet
        Pet oldestPet = clinic.getOldestPet();
        System.out.println(oldestPet); // Zak 4 (Jon)

// Get Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations.Pet
        Pet pet = clinic.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 (Mia)

// Count
        System.out.println(clinic.getCount()); // 2

// Get Statistics
        System.out.println(clinic.getStatistics());

    }
}
