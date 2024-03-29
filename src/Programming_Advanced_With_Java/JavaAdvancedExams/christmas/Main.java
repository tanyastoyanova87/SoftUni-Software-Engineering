package Programming_Advanced_With_Java.JavaAdvancedExams.christmas;

public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag("black", 10);

// Initialize entity
        Present present = new Present("Doll", 0.4, "girl");

        System.out.println(present); // Present Doll (0.40) for a girl

// Add Present
        bag.add(present);

// Remove Present
        bag.remove("Toy"); // false

        Present secondPresent = new Present("Train", 2, "boy");
// Add Present
        bag.add(secondPresent);

        Present heaviestPresent = bag.heaviestPresent();
        System.out.println(heaviestPresent);
// Present Train (2.00) for a boy

        Present p = bag.getPresent("Doll");
        System.out.println(p);
// Present Doll (0.40) for a girl

        System.out.println(bag.count()); // 2
        System.out.println(bag.report());

    }
}
