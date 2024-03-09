package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P03Animals;

public class Main {
    public static void main(String[] args) {

        Animal cat = new Cat("Oscar", "Whiskas");

        Animal dog = new Dog("Rocky", "P04WildFarm.P04WildFarm.Meat");

        System.out.println(cat.explainSelf());

        System.out.println(dog.explainSelf());
    }
}
