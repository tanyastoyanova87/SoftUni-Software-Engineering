package Programming_Advanced_With_Java.JavaAdvancedExams.kindergarten;

public class Main {
    public static void main(String[] args) {

        Kindergarten kindergarten = new Kindergarten("Sunshine", 8);

        Child childOne = new Child("Lilyana", "Petrova", 3, "Selena", "0899");
        Child childTwo = new Child("Elona", "Muskova", 4, "Max", "0888");
        Child childThree = new Child("George", "Bush", 5, "Ivan", "0988");

        System.out.println(kindergarten.addChild(childOne));
        System.out.println(kindergarten.addChild(childTwo));
        System.out.println(kindergarten.addChild(childThree));

        System.out.println(kindergarten.removeChild("Elona"));
        System.out.println(kindergarten.removeChild("Ivana"));

        System.out.println(kindergarten.getChildrenCount());

        Child getChild = kindergarten.getChild("Lilyana");
        System.out.println(getChild);

        System.out.println(kindergarten.registryReport());
    }
}
