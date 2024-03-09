package Programming_Advanced_With_Java.JavaAdvancedExams.parrots;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cage cage = new Cage("Wildness", 20);
        Parrot parrot = new Parrot("Willy", "Loriinae");

        System.out.println(parrot);

        cage.add(parrot);

        System.out.println(cage.count());

        System.out.println(cage.remove("Par"));

        Parrot secondParrot = new Parrot("Bunny", "Cacatuidae");
        Parrot thirdParrot = new Parrot("Jumpy", "Strigopoidea");
        Parrot fourthParrot = new Parrot("Puffy", "Strigopoidea");
        Parrot fifthParrot = new Parrot("Marlin", "Arinae");

        cage.add(secondParrot);
        cage.add(thirdParrot);
        cage.add(fourthParrot);
        cage.add(fifthParrot);

        System.out.println(cage.sellParrot("Bunny"));

        List<Parrot> soldSpecies = cage.sellParrotBySpecies("Strigopoidea");
        soldSpecies.forEach(i -> System.out.println(i.getName()));

        System.out.println(cage.report());
    }
}
